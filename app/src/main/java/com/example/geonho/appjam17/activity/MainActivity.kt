package com.example.geonho.appjam17.activity

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.widget.Toast
import com.example.geonho.appjam17.R
import com.example.geonho.appjam17.fragment.*
import com.example.geonho.appjam17.util.StatusBarUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val finishTime = 2000
    private var backPressedTime:Long = 0
    lateinit var fragment : Fragment

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottomOne -> {
                    fragment = FlowerFragment.newInstance()
                }
                R.id.bottomTwo -> {
                    fragment = SearchFragment.newInstance()
                }
                R.id.bottomThree -> {
                    fragment = HomeFragment.newInstance()
                }
                R.id.bottomFour -> {
                    fragment = FavoriteFragment.newInstance()
                }
                R.id.bottomFive -> {
                    fragment = EtcFragment.newInstance()
                }

            }
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit()
            true
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setStatusBarColor(window, Color.WHITE)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, HomeFragment.newInstance()).commit()
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun onBackPressed() {
        val tempTime = System.currentTimeMillis()
        val intervalTime = tempTime - backPressedTime
        if (intervalTime in 0..finishTime) {
            ActivityCompat.finishAffinity(this)
        } else {
            backPressedTime = tempTime
            Toast.makeText(applicationContext, "한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show()
        }
    }
}
