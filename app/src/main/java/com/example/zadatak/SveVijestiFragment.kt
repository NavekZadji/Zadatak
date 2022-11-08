package com.example.zadatak

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zadatak.databinding.SveVijestiBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class SveVijestiFragment : Fragment() {


    private var _binding: SveVijestiBinding? = null
    private val viewModel by viewModel<NewsViewModel>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = SveVijestiBinding.inflate(inflater, container, false)
        val recyclerView = _binding!!.recyclerViewSve
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        lifecycleScope.launch {

            val sveVijestiPrimjer = viewModel.getNewsSve()
            val naslov0 = sveVijestiPrimjer.body()!!.articles[0].title
            val naslov1 = sveVijestiPrimjer.body()!!.articles[1].title
            val naslov2 = sveVijestiPrimjer.body()!!.articles[2].title
            val naslov3 = sveVijestiPrimjer.body()!!.articles[3].title
            val naslov4 = sveVijestiPrimjer.body()!!.articles[4].title

            Log.v("Sve vijesti Naslov0:",naslov0)


            val dataList = arrayListOf<String>(naslov0,naslov1,naslov2,naslov3,naslov4)
            val rvAdapter = RvAdapter(dataList)
            recyclerView.adapter = rvAdapter
        }

        return binding.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}