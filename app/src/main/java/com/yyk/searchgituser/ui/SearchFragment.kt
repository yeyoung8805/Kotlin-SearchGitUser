package com.yyk.searchgituser.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.yyk.searchgituser.adapter.SearchRecyclerViewAdapter
import com.yyk.searchgituser.data.AppDatabase
import com.yyk.searchgituser.data.GitUserDao
import com.yyk.searchgituser.data.ResultStatus
import com.yyk.searchgituser.databinding.FragmentSearchBinding
import com.yyk.searchgituser.viewModel.SearchViewModel
import com.yyk.searchgituser.viewModel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private lateinit var searchFragmentBinding: FragmentSearchBinding
    lateinit var gitUserDao: GitUserDao
    private val sharedViewModel: SharedViewModel by activityViewModels()

    private val searchViewModel : SearchViewModel by viewModels()

    @Inject
    lateinit var searchRecyclerViewAdapter : SearchRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        gitUserDao = AppDatabase.getInstance(requireContext()).gitUserDao()
        searchFragmentBinding = FragmentSearchBinding.inflate(inflater, container, false).apply {
            viewModel = searchViewModel
            lifecycleOwner = this@SearchFragment
        }
        return searchFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchFragmentBinding.rvUserList.adapter = searchRecyclerViewAdapter.apply {
            onClickLikeBtn = {
                //TODO
                Log.e("onClickLikeBtn Frag :: ", "$it")
                Log.e("onClickLikeBtn Frag :: ", "${searchViewModel.gitUsers.value?.get(it)}")
                lifecycleScope.launch {
                    searchViewModel.changeLikeStatus(it).observe(viewLifecycleOwner) { result ->
                        when(result) {
                            ResultStatus.Loading -> {
                                Toast.makeText(
                                    requireContext(),
                                    "Database insert",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            is ResultStatus.Error -> {
                                Toast.makeText(
                                    requireContext(),
                                    "failure ${result.throwable}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            is ResultStatus.Success -> {
                                if(result.data > 0) {
                                    sharedViewModel.update.value = true
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}