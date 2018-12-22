package com.example.geonho.appjam17.fragment

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geonho.appjam17.BR

import com.example.geonho.appjam17.R
import com.example.geonho.appjam17.databinding.ItemDefaultRecyclerBinding
import com.example.geonho.appjam17.server.SearchResult
import com.example.geonho.appjam17.util.SharedPreferenceUtil
import com.github.nitrico.lastadapter.LastAdapter
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.view.*
import kotlinx.android.synthetic.main.item_default_recycler.view.*


class SearchFragment : Fragment() {

    lateinit var fragmentView:View
    var items :MutableList<String> = ArrayList()
    lateinit var resultItems : List<SearchResult>

    companion object {
        @JvmStatic
        fun newInstance() = SearchFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentView =  inflater.inflate(R.layout.fragment_search, container, false)

        items.addAll(SharedPreferenceUtil.getList(context!!,"item"))
        initRecyclerView()
        setListeners()

        return fragmentView
    }

    private fun setListeners(){
        fragmentView.searchButton.setOnClickListener {
            addData()
        }
        fragmentView.text1.setOnClickListener {
            fragmentView.searchEdit.setText(fragmentView.text1.toString())
        }
        fragmentView.text2.setOnClickListener {
            fragmentView.searchEdit.setText(fragmentView.text2.toString())
        }
        fragmentView.text3.setOnClickListener {
            fragmentView.searchEdit.setText(fragmentView.text3.toString())
        }
        fragmentView.text4.setOnClickListener {
            fragmentView.searchEdit.setText(fragmentView.text4.toString())
        }
        fragmentView.text5.setOnClickListener {
            fragmentView.searchEdit.setText(fragmentView.text5.toString())
        }
    }

    private fun addData(){
        items.add(fragmentView.searchEdit.text.toString())
        SharedPreferenceUtil.saveList(context!!,items,"item")
        items.addAll(SharedPreferenceUtil.getList(context!!,"item"))
        initRecyclerView()

        fragmentView.searchLayout.visibility = View.GONE
        fragmentView.resultLayout.visibility = View.VISIBLE
    }

    private fun initRecyclerView(){
        recentRecyclerView.layoutManager = LinearLayoutManager(context)

        LastAdapter(items, BR.items)
            .map<String, ItemDefaultRecyclerBinding>(R.layout.item_default_recycler){
                onBind {
                    it.binding.recentText.setOnClickListener {
                        fragmentView.searchEdit.setText(fragmentView.recentText.toString())
                    }
                }
            }
            .into(recentRecyclerView)
    }
}
