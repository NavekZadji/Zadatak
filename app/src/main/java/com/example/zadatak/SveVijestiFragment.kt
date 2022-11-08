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
            val nasloviSve = arrayListOf<String>()
            for (i in 0..19) {

                nasloviSve.add(sveVijestiPrimjer.body()!!.articles[i].title)
            }

            val rvAdapter = RvAdapter(nasloviSve)
            recyclerView.adapter = rvAdapter
        }

        return binding.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}