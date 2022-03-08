package com.yyk.searchgituser.viewModel

import androidx.lifecycle.*
import com.yyk.searchgituser.data.Data
import com.yyk.searchgituser.repository.GitUserDBRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DatabaseViewModel @Inject constructor(private val gitUserDBRepo : GitUserDBRepository): ViewModel() {

    private val _gitUsers = MutableLiveData<ArrayList<Data>>()
    val gitUsers : LiveData<ArrayList<Data>> = _gitUsers

    init {
        getList()
    }

    fun getList() {
        viewModelScope.launch(Dispatchers.IO) {
            _gitUsers.postValue(ArrayList(gitUserDBRepo.selectAll()))
        }
    }

    fun changeStatus(position: Int) = gitUserDBRepo.changeLikeStatus(position, _gitUsers.value)
}

