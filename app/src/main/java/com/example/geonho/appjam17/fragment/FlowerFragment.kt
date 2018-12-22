package com.example.geonho.appjam17.fragment

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.geonho.appjam17.BR
import com.example.geonho.appjam17.R
import com.example.geonho.appjam17.VendingMachine
import com.example.geonho.appjam17.databinding.ItemFlowerVendingMachineBinding
import com.github.nitrico.lastadapter.LastAdapter
import kotlinx.android.synthetic.main.fragment_flower.*


class FlowerFragment : Fragment() {

    lateinit var fragmentView: View

    var allItems = ArrayList<ArrayList<VendingMachine>>()
    var items = ArrayList<VendingMachine>()

    var tabs = ArrayList<TextView>()

    companion object {
        @JvmStatic
        fun newInstance() = FlowerFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        fragmentView = inflater.inflate(R.layout.fragment_flower, container, false)
        return fragmentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        allItems.run {
            add(ArrayList<VendingMachine>().apply {
                add(VendingMachine("가락점", "서울 송파구 가락동 82-5 1층"))
                add(VendingMachine("문점", "서울 송파구 법원로 127 1층"))
                add(VendingMachine("홍대 1점", "서울 마포구 서교동 332-3 1층"))
                add(VendingMachine("홍대 2점", "서울 마포구 서교동 331-14 1층"))
                add(VendingMachine("건대점", "서울 광진구 자양동 12-1 1층"))
                add(VendingMachine("삼청점", "서울 종로구 삼청로 104-1 1층"))
                add(VendingMachine("신당점", "서울 중구 다산로 167 태양마트 1층"))
                add(VendingMachine("태평로점", "서울 중구 태평로2가 69-1 "))
                add(VendingMachine("레드점", "서울 종로구 관철동 14-8 레드컨테이너"))
            })
            add(ArrayList<VendingMachine>().apply {
                add(VendingMachine("풍덕천점", "경기 용인시 수지구 풍덕천로129번길"))
                add(VendingMachine("동백점", "경기 용인시 기흥구 동백5로 21-8"))
            })
            add(ArrayList<VendingMachine>().apply {
                add(VendingMachine("순천점", "전남 순천시 해룡면 해광로 199"))
                add(VendingMachine("웅천점", "전남 여수시 웅천로 19-35 (웅천동) "))
            })

            add(ArrayList<VendingMachine>().apply {
                add(VendingMachine("cgv 대한", "부산 부산진구 중앙대로692번길 16"))
                add(VendingMachine("cgv 해운대", "부산 해운대구 해운대로 620 "))
            })
        }

        tabs.run {
            add(tab1)
            add(tab2)
            add(tab3)
            add(tab4)
        }

        items.addAll(allItems.first())
        tabs.first().setTextColor(Color.BLACK)

        tabs.forEachIndexed { index, view ->
            view.setOnClickListener {
                tabs.forEachIndexed { i, tv ->
                    tv.setTextColor(if (i == index) Color.BLACK else Color.parseColor("#808080"))
                }
                items.clear()
                items.addAll(allItems[index])
                recyclerView.adapter?.notifyDataSetChanged()
            }
        }
        initRecyclerView()

    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        LastAdapter(items, BR.item)
            .map<VendingMachine, ItemFlowerVendingMachineBinding>(R.layout.item_flower_vending_machine) {
                onBind {
                    it.binding.titleTextView.text = "${it.binding.item?.title}"
                    it.binding.rankTextView.text = "${it.adapterPosition + 1}"
                    it.binding.addressTextView.text = "${it.binding.item?.address}"

                }
            }
            .into(recyclerView)
    }

}
