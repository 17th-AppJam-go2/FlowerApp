package com.example.geonho.appjam17.activity

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.geonho.appjam17.R
import com.example.geonho.appjam17.util.StatusBarUtil

class HomeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setStatusBarColor(window, Color.WHITE)
        setContentView(R.layout.activity_home_detail)
    }
}
