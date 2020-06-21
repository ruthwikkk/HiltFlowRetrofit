package com.ruthwikkk.sample.flowhiltretrofit.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.ruthwikkk.sample.flowhiltretrofit.R
import com.ruthwikkk.sample.flowhiltretrofit.adapters.RocketsAdapter
import com.ruthwikkk.sample.flowhiltretrofit.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = RocketsAdapter()
        rv_rockets_list.adapter = adapter

        mainViewModel.apply {

            rocketsLiveData.observe(this@MainActivity, Observer {
                if (it.isNullOrEmpty()) {

                } else {
                    adapter.setItems(it)
                }
            })
        }
    }
}