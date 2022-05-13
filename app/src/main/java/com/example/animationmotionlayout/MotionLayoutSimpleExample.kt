package com.example.animationmotionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animationmotionlayout.databinding.ActivityBottomToTopBinding
import com.example.animationmotionlayout.databinding.ActivityMotionLayoutBinding

class MotionLayoutSimpleExample: AppCompatActivity() {

    private lateinit var binding: ActivityMotionLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMotionLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}