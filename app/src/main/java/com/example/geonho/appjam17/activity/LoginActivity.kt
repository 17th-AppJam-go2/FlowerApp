package com.example.geonho.appjam17.activity

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.geonho.appjam17.R
import com.example.geonho.appjam17.util.NetworkHelper
import com.example.geonho.appjam17.util.StatusBarUtil
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setStatusBarColor(window, Color.WHITE)
        setContentView(R.layout.activity_login)

        loginButton.setOnClickListener {
            NetworkHelper.retrofitInstance.signIn(idEdit.text.toString(), pwEdit.text.toString())
                .enqueue(object : Callback<ResponseBody> {
                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        Log.e("asdf", "login failed")
                    }

                    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                        if (response.code() == 200)
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        else
                            Log.e("asdf", "login failed")
                    }
                })
        }

        registerText.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterChoiceActivity::class.java))
        }
    }
}

