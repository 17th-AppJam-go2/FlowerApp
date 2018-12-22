package com.example.geonho.appjam17.util

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceUtil {

    fun getData(context : Context, key : String) : String? {
        val sharedPreferences : SharedPreferences = context.getSharedPreferences("test",Context.MODE_PRIVATE)
        return sharedPreferences.getString(key, null)
    }

    fun saveData(context: Context, key : String, value : String) {
        val sharedPreferences : SharedPreferences = context.getSharedPreferences("test", Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun saveList(context: Context,list:List<String>,key: String){
        val sharedPreferences = context.getSharedPreferences("test",Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putStringSet(key, list.toMutableSet()).apply()
    }

    fun getList(context: Context,key: String):List<String>{
        val sharedPreferences = context.getSharedPreferences("test",Context.MODE_PRIVATE)
        return sharedPreferences.getStringSet(key, mutableSetOf()).toList()
    }

    fun removePreferences(context: Context, key: String) {
        val pref = context.getSharedPreferences("test", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.remove(key)
        editor.apply()
    }

}