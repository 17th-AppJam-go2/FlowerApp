package com.example.geonho.appjam17.activity

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.geonho.appjam17.R
import com.example.geonho.appjam17.util.StatusBarUtil

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setStatusBarColoc(window, Color.WHITE)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({

            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
        }, 2000)

    }

}
