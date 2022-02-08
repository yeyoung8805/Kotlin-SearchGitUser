package com.yyk.searchgituser

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.yyk.searchgituser.adapter.RecyclerViewAdapter
import com.yyk.searchgituser.databinding.ActivityMainBinding
import com.yyk.searchgituser.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
//    private val adapter: RecyclerViewAdapter by lazy {
//        RecyclerViewAdapter()
//    }
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

//    private val mainViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        binding.lifecycleOwner = this@MainActivity
//        binding.viewModel = mainViewModel

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

//        initializeAdapter()
    }

//    private fun initializeAdapter() {
//        binding.rvUserList.run {
//            adapter = this@MainActivity.adapter
//            layoutManager = LinearLayoutManager(this@MainActivity)
//        }
//    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


}

