package com.example.geonho.appjam17.util

import android.graphics.Color
import android.os.Build
import android.support.v4.content.res.ResourcesCompat
import android.view.Window
import android.view.WindowManager

object StatusBarUtil {
    fun setStatusBarColoc(window: Window, color: Int) {
        window.run {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                statusBarColor = color
            }
        }
    }
}