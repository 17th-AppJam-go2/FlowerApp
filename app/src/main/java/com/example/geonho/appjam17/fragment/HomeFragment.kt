package com.example.geonho.appjam17.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geonho.appjam17.BR

import com.example.geonho.appjam17.R
import com.example.geonho.appjam17.server.Ranking
import com.github.nitrico.lastadapter.LastAdapter
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    lateinit var fragmentView:View

    val items = ArrayList<Ranking>().apply {
        add(Ranking(R.drawable.ranking_one,"MONDAY FLOWERS","특별한 순간을 선사하는 아름다움을 지금 선물하세요.\n" +
                "자연의 컬러는 많은 힘이 있습니다. 당신에게 부족한 컬러를 꽃으로 채워보세요."))
        add(Ranking(R.drawable.ranking_two,"라플레르","사랑하는 사람에게 한 송이의 꽃을 선물하세요.\n" +
                "각 종 이벤트에 어울리는 스폐셜 상품이 준비되어 있습니다."))
        add(Ranking(R.drawable.ranking_three,"Zita Elze Flowers","겨울 꽃다발과 크리스마스 데코레이션.\n" +
                "지타 엘체 플라워즈는 영국내 전역은 물론 전 세계적으로 배송이 가능합니다."))
    }
    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        fragmentView =  inflater.inflate(R.layout.fragment_home, container, false)
        return fragmentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(context)
        LastAdapter(items, BR.items)
            .map<String>(R.layout.item_ranking)
            .into(recyclerView)
    }
}
