package com.example.animationmotionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animationmotionlayout.databinding.ActivityMainBinding
import com.example.animationmotionlayout.databinding.ActivityMotionLayoutBinding
import com.example.animationmotionlayout.databinding.GifLayoutBinding
import com.example.animationmotionlayout.databinding.LottieAnimationBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: GifLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GifLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}