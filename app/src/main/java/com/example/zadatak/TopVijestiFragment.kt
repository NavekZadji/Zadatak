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
import com.example.zadatak.databinding.TopVijestiBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class TopVijestiFragment : Fragment() {


    private var _binding: TopVijestiBinding? = null
    private val viewModel by viewModel<NewsViewModel>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = TopVijestiBinding.inflate(inflater, container, false)
        val recyclerView = _binding!!.recyclerViewTop
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        lifecycleScope.launch {
            val topVijestiPrimjer = viewModel.getNews()
            val nasloviTop = arrayListOf<String>()

            for (i in 0..19) {

                nasloviTop.add(topVijestiPrimjer.body()!!.articles[i].title)
            }

            val rvAdapter = RvAdapter(nasloviTop)
            recyclerView.adapter = rvAdapter
        }

        return binding.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}