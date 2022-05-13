package com.example.animationmotionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animationmotionlayout.databinding.ActivityBottomToTopBinding
import com.example.animationmotionlayout.databinding.ActivityMotionLayoutBinding

class MotionLayoutBottomLayoutDuration: AppCompatActivity() {

    private lateinit var binding: ActivityBottomToTopBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomToTopBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}