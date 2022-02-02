package com.yyk.searchgituser

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.yyk.searchgituser.adapter.RecyclerViewAdapter
import com.yyk.searchgituser.databinding.ActivityMainBinding
import com.yyk.searchgituser.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter: RecyclerViewAdapter by lazy {
        RecyclerViewAdapter()
    }

    private val mainViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = mainViewModel

        mainViewModel.result.observe(this) {
            adapter.datalist = it
            adapter.notifyDataSetChanged()
        }

        initializeAdapter()
    }

    private fun initializeAdapter() {
        binding.rvUserList.run {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}

