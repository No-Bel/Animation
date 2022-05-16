package com.example.animationmotionlayout

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.animation.LinearInterpolator
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.animationmotionlayout.databinding.ValueAnimationLayoutBinding
import kotlinx.android.synthetic.main.value_animation_layout.*

class ValueAnimationPlainDuration : AppCompatActivity() {

    private lateinit var binding: ValueAnimationLayoutBinding

    private val screenHeight = 1800f
    var num = 0
    private var result1 = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ValueAnimationLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        incrementNumValueAnimation()
        clickOnIcon()
        animationListenerOnClick()
    }

    private fun animationListenerOnClick() {
        binding.iconPlane.setOnClickListener {
            animationListener()
            backToStartPosition()
        }
    }

    private fun clickOnIcon() {
        binding.iconPlane.setOnClickListener {
//            airplaneIconValueAnimation()
//            backToStartPosition()
            animatorSet()
//            animationListener()
        }


        binding.incBtn.setOnClickListener {
            incrementNumValueAnimation()
            backToStartPosition()
        }
    }

    private fun backToStartPosition() {
        binding.iconPlane.animate()
            .translationY(0f)
            .duration = 1000
    }


    private fun airplaneIconValueAnimation() {

        ValueAnimator.ofFloat(0f, -screenHeight).apply {
            addUpdateListener {
                val value = it.animatedValue as Float
                icon_plane.translationY = value
            }

            interpolator = LinearInterpolator()
//            interpolator = AccelerateInterpolator(1.5f)
            duration = 1000
            start()
        }
    }

    private fun incrementNumValueAnimation() {
        val score: TextView = findViewById(R.id.score_tv)

        val anim = ValueAnimator.ofInt(num)

        anim.addUpdateListener {
            score.text = anim.animatedValue.toString()
        }

        anim.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
                num += result1
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationRepeat(p0: Animator?) {
            }

        })
        anim.duration = 500
        anim.start()
    }

    private fun animatorSet() {
        AnimatorSet().apply {
////            playSequentially(
//                ObjectAnimator.ofFloat(binding.iconPlane, "translationY", 0f, -screenHeight),
//                ObjectAnimator.ofFloat(binding.incBtn, "translationY", 0f, -screenHeight)
////            )
            playTogether(ObjectAnimator.ofFloat(binding.iconPlane, "translationY", 0f, -screenHeight),
                ObjectAnimator.ofFloat(binding.incBtn, "translationY", 0f, -screenHeight))

            duration = 1000
            start()
        }
    }



    /** Object Animation */
    private fun airplaneIconObjectAnimation() {
        ObjectAnimator.ofFloat(binding.iconPlane, "translationY", 0f, -screenHeight).apply {
            duration = 1000
            start()
        }
    }

    /** Example 3 Value and Object Animation */
    private fun bothAnimationTogether() {
        val positionAnimator = ValueAnimator.ofFloat(0f, -screenHeight).apply {
            addUpdateListener {
                val value = it.animatedValue as Float
                binding.iconPlane.translationY = value
            }
        }

        val rotationAnimator = ObjectAnimator.ofFloat(binding.iconPlane, "rotation", 0f, 180f)
        AnimatorSet().apply {
            play(positionAnimator).with(rotationAnimator)
            duration = 1000
            start()
        }
    }

    /** Example 4 Property Animation*/
    private fun propertyAnimator() {
        binding.iconPlane.animate()
            .translationY(-screenHeight)
            .rotationBy(360f)
            .duration = 1000
    }

    private fun animationListener() {
        ValueAnimator.ofFloat(0f, -screenHeight).apply {
            addUpdateListener {
                val value = it.animatedValue as Float
                binding.iconPlane.translationY = value
            }
            addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(p0: Animator?) {
                    Toast.makeText(
                        this@ValueAnimationPlainDuration,
                        "make airplane fly",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

                override fun onAnimationEnd(p0: Animator?) {
                    Toast.makeText(
                        this@ValueAnimationPlainDuration,
                        "airplane in Tbilisi",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

                override fun onAnimationCancel(p0: Animator?) {

                }

                override fun onAnimationRepeat(p0: Animator?) {

                }

            })
            duration = 1000
            repeatMode = ValueAnimator.REVERSE
            repeatCount = 2
            start()
        }
    }
}