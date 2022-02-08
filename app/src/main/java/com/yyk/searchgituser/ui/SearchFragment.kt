package com.yyk.searchgituser.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.yyk.searchgituser.R
import com.yyk.searchgituser.adapter.RecyclerViewAdapter
import com.yyk.searchgituser.databinding.FragmentSearchBinding
import com.yyk.searchgituser.viewModel.MainViewModel

class SearchFragment : Fragment() {
//    var binding: FragmentSearchBinding
    lateinit var binding: FragmentSearchBinding
//    private val binding: FragmentSearchBinding by lazy {
//        initializeAdapter()
//    }
    private val mainViewModel : MainViewModel by viewModels()
    private val adapter: RecyclerViewAdapter by lazy {
        RecyclerViewAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

//        val view = inflater.inflate(R.layout.search_fragment, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        binding.apply {
            binding.lifecycleOwner = this@SearchFragment
            binding.viewModel = mainViewModel
        }

        initializeAdapter()
        return binding.root

    }

    private fun initializeAdapter() {
        binding.rvUserList.run {
            adapter = this@SearchFragment.adapter
            layoutManager = LinearLayoutManager(this@SearchFragment.context)
        }
    }
}