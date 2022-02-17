package com.yyk.searchgituser.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.yyk.searchgituser.adapter.SearchRecyclerViewAdapter
import com.yyk.searchgituser.data.AppDatabase
import com.yyk.searchgituser.data.GitUserDao
import com.yyk.searchgituser.databinding.FragmentDatabaseBinding
import com.yyk.searchgituser.repository.GitUserDBRepository
import com.yyk.searchgituser.viewModel.DatabaseViewModel
import com.yyk.searchgituser.viewModel.DatabaseViewModelFactory
import com.yyk.searchgituser.viewModel.SharedViewModel

class DatabaseFragment : Fragment() {

    private lateinit var databaseFragmentBinding : FragmentDatabaseBinding
    lateinit var gitUserDao: GitUserDao
    private val databaseViewModel: DatabaseViewModel by viewModels { DatabaseViewModelFactory(
        GitUserDBRepository(gitUserDao)
    ) }
    private val shareViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val view = inflater.inflate(R.layout.fragment_star, container, false)

        gitUserDao = AppDatabase.getInstance(requireContext()).gitUserDao()
        databaseFragmentBinding = FragmentDatabaseBinding.inflate(inflater, container, false).apply {
            vm = databaseViewModel
            lifecycleOwner = this@DatabaseFragment
        }

        //방법1 코틀린 상위버전 1.6.10
        shareViewModel.update.observe(viewLifecycleOwner) {
            if(it) {
                Log.e("yyk :: ", "UPDATE")
                databaseViewModel.update()
            }
        }

        //방법2 코틀린 하위버전 1.3.72
//        shareViewModel.update.observe(viewLifecycleOwner, Observer {
//            if(it) {
//                Log.e("yyk :: ", "UPDATE")
//                databaseViewModel.update()
//            }
//        })

        return databaseFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databaseFragmentBinding.githubUserView.adapter = SearchRecyclerViewAdapter()
    }
}