package com.yyk.searchgituser.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
    val update = MutableLiveData<Boolean>()
}