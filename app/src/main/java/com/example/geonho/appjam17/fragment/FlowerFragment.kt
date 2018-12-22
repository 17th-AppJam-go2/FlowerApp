package com.example.geonho.appjam17.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.geonho.appjam17.R


class FlowerFragment : Fragment() {

    lateinit var fragmentView:View

    companion object {
        @JvmStatic
        fun newInstance() = FlowerFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        fragmentView =  inflater.inflate(R.layout.fragment_flower, container, false)
        return fragmentView
    }
}
