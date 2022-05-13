package com.example.animationmotionlayout

import android.animation.Animator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.animationmotionlayout.databinding.BottomLayoutValueAnimationBinding
import kotlinx.android.synthetic.main.bottom_layout_value_animation.*
import kotlinx.android.synthetic.main.value_animation_layout.*

class ValueAnimationBottomLayoutDuration: AppCompatActivity() {

    private lateinit var binding: BottomLayoutValueAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BottomLayoutValueAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickOnIcon()
    }

    private fun clickOnIcon() {

        binding.showBottomLayoutBtn2.setOnClickListener {
            bottomLayoutValueAnimationFirstOne()
        }

        binding.btn2.setOnClickListener {
            bottomLayoutValueAnimationSecondOne()
        }
    }


    private fun bottomLayoutValueAnimationFirstOne() {

        ValueAnimator.ofFloat(binding.rootContainer.height.toFloat(), 0f ).apply {
            addUpdateListener {
                val value = it.animatedValue as Float
                binding.bottomLayout2.translationY = value
            }
            addListener(object : Animator.AnimatorListener{
                override fun onAnimationStart(p0: Animator?) {
                    binding.bottomLayout2.visibility = View.VISIBLE
                }

                override fun onAnimationEnd(p0: Animator?) {
                }

                override fun onAnimationCancel(p0: Animator?) {
                }

                override fun onAnimationRepeat(p0: Animator?) {
                }
            })
            interpolator = LinearInterpolator()
            duration = 1000
            start()

        }

    }

    private fun bottomLayoutValueAnimationSecondOne() {
        ValueAnimator.ofInt(binding.bottomLayout2.height,  binding.root.height).apply {
            addUpdateListener {
                val params = binding.bottomLayout2.layoutParams
                params.height = it.animatedValue as Int
                binding.bottomLayout2.layoutParams = params
            }

            addListener(object : Animator.AnimatorListener{
                override fun onAnimationStart(p0: Animator?) {
                    binding.bottomLayout2.visibility = View.VISIBLE
                }

                override fun onAnimationEnd(p0: Animator?) {
                }

                override fun onAnimationCancel(p0: Animator?) {
                }

                override fun onAnimationRepeat(p0: Animator?) {
                }
            })
            interpolator = LinearInterpolator()
            duration = 1000
            start()
        }
    }
}