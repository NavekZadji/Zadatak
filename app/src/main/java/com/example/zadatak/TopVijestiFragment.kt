package com.example.zadatak

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zadatak.databinding.TopVijestiBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
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
            val naslov0 = topVijestiPrimjer.body()!!.articles[0].title
            val naslov1 = topVijestiPrimjer.body()!!.articles[1].title
            val naslov2 = topVijestiPrimjer.body()!!.articles[2].title
            val dataList = arrayListOf<String>(naslov0,naslov1,naslov2)
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