package com.example.icacraft.ui.home.newarrival

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.icacraft.R
import com.example.icacraft.model.dummy.HomeModel
import com.example.icacraft.model.dummy.HomeVerticalModel
import com.example.icacraft.ui.detail.DetailActivity
import com.example.icacraft.ui.home.HomeAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.rclist
import kotlinx.android.synthetic.main.fragment_home_new_arrival.*
import java.util.ArrayList

class HomeNewArrivalFragment : Fragment(), HomeNewArrivalAdapter.ItemAdapterCallback {

    private var craftlist : ArrayList<HomeVerticalModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_new_arrival, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDataDummy()
        var adapter = HomeNewArrivalAdapter(craftlist, this)
        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        rcList.layoutManager = layoutManager
        rcList.adapter = adapter
    }

    fun initDataDummy() {
        craftlist = ArrayList()
        craftlist.add(HomeVerticalModel("Starp Mask", "2500","", 5f))
        craftlist.add(HomeVerticalModel("Gantungan Kunci", "1000","" , 3f))
        craftlist.add(HomeVerticalModel("Dream Catcher", "5000", "",4f))
    }

    override fun onClick(v: View, data: HomeVerticalModel) {

        val detail = Intent(activity, DetailActivity::class.java)
        startActivity(detail)
    }

}