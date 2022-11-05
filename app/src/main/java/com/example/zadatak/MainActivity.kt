package com.example.zadatak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent
import kotlinx.android.synthetic.main.activity_main.*
import androidx.annotation.Nullable
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity(), KoinComponent {

    private val viewModel by viewModel<NewsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            val nasloviTopVijesti = viewModel.getNews()
            val probno0 = nasloviTopVijesti.body()!!.articles[0].title
            Log.v("Probno:", probno0)
        }

        var tab_toolbar = findViewById<Toolbar>(R.id.toolbar)
        var tab_viewpage = findViewById<ViewPager>(R.id.tab_viewpager)
        var tab_tablayout = findViewById<TabLayout>(R.id.tab_tablayout)

        setSupportActionBar(tab_toolbar)
        setupViewPager(tab_viewpager)
        tab_tablayout.setupWithViewPager(tab_viewpager)

    }

    private fun setupViewPager(viewpager: ViewPager) {
        var adapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        // LoginFragment is the name of Fragment and the Login
        // is a title of tab
        adapter.addFragment(TopVijestiFragment(), "Login")
        adapter.addFragment(SveVijestiFragment(), "Signup")

        // setting adapter to view pager.
        viewpager.setAdapter(adapter)
    }

}
