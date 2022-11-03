package com.example.zadatak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.viewpager.widget.ViewPager
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

        /*       // ovaj dio crasha aplikaciju, treba to rijesiti s viewholderom a ne ovak
        lifecycleScope.launch {
            val nasloviTopVijesti = viewModel.getNews()
            val probno = nasloviTopVijesti.body()?.articles?.elementAt(0)?.title
            if (probno != null) {
                Log.v("Probno:", probno)
            }

        }*/

            val data = arrayOf("aa", "bb", "cc", "dd")
            pager.adapter = ViewPagerAdapter(data)
            // prepoznal je xml objekt tek dok sam dodal v gradle apply plugin: 'com.android.application'  apply plugin: 'kotlin-android'  apply plugin: 'kotlin-android-extensions'
            // i jos v MainActivity import kotlinx.android.synthetic.main.activity_main.*
            pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    //Toast.makeText(this@MainActivity, "onPageSelected", Toast.LENGTH_SHORT).show()
                }
            })


    }
}
