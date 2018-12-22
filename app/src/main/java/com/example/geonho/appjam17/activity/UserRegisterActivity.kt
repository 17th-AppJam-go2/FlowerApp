package com.example.geonho.appjam17.activity

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.geonho.appjam17.R
import com.example.geonho.appjam17.util.NetworkHelper
import com.example.geonho.appjam17.util.StatusBarUtil
import kotlinx.android.synthetic.main.activity_user_register.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setStatusBarColor(window, Color.WHITE)
        setContentView(R.layout.activity_user_register)

        registerButton.setOnClickListener {
            signUp()
        }
    }

    private fun signUp() {
        idEdit.text.toString()
        pwEdit.text.toString()
        pwCheckEdit.text.toString()

        NetworkHelper.retrofitInstance.signUp("User", idEdit.text.toString(), pwEdit.text.toString())
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                }

                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if (response.code() == 200) {
                        finishAffinity()
                        startActivity(Intent(this@UserRegisterActivity, MainActivity::class.java))
                    } else {
                        Toast.makeText(this@UserRegisterActivity, "회원가입 실패", Toast.LENGTH_SHORT).show()
                    }
                }
            })
    }
}
