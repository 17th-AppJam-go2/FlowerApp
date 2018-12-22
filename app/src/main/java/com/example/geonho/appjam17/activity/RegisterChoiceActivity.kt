package com.example.geonho.appjam17.activity

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.geonho.appjam17.R
import com.example.geonho.appjam17.util.StatusBarUtil
import kotlinx.android.synthetic.main.activity_choice_register.*

class RegisterChoiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setStatusBarColoc(window, Color.WHITE)
        setContentView(R.layout.activity_choice_register)

        userButton.setOnClickListener {
            startActivity(Intent(this,UserRegisterActivity::class.java))
        }

        ceoButton.setOnClickListener {
            startActivity(Intent(this,CeoRegisterActivity::class.java))
        }
    }
}
