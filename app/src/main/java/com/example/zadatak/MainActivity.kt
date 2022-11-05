package com.example.zadatak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), KoinComponent {

    private val viewModel by viewModel<NewsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            val nasloviTopVijesti = viewModel.getNews()
            val probno0 = nasloviTopVijesti.body()!!.articles[0].title
            val probno1 = nasloviTopVijesti.body()!!.articles[1].title
            val probno2 = nasloviTopVijesti.body()!!.articles[2].title
            val probno3 = nasloviTopVijesti.body()!!.articles[3].title
            val probno4 = nasloviTopVijesti.body()!!.articles[4].title

            Log.v("Probno:", probno0)

            val data = arrayOf(probno0, probno1, probno2, probno3, probno4)
            pager.adapter = ViewPagerAdapter(data)
            // prepoznal je xml objekt tek dok sam dodal v gradle apply plugin: 'com.android.application'  apply plugin: 'kotlin-android'  apply plugin: 'kotlin-android-extensions'
            // i jos v MainActivity import kotlinx.android.synthetic.main.activity_main.*
            pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

            val nasloviSveVijesti = viewModel.getNewsSve()
            val probnoSve0 = nasloviSveVijesti.body()!!.articles[0].title
            val probnoSve1 = nasloviSveVijesti.body()!!.articles[1].title
            val probnoSve2 = nasloviSveVijesti.body()!!.articles[2].title
            val probnoSve3 = nasloviSveVijesti.body()!!.articles[3].title
            val probnoSve4 = nasloviSveVijesti.body()!!.articles[4].title

            val dataSve = arrayOf(probnoSve0,probnoSve1,probnoSve2,probnoSve3,probnoSve4)

        }

    }
}
