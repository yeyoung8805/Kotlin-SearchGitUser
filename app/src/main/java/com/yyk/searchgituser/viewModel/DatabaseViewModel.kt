package com.yyk.searchgituser.viewModel

import androidx.lifecycle.*
import com.yyk.searchgituser.data.Data
import com.yyk.searchgituser.repository.GitUserDBRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class DatabaseViewModel(private val gitUserDBRepo : GitUserDBRepository): ViewModel() {

    private val _gitUsers = MutableLiveData<ArrayList<Data>>()
    val gitUsers : LiveData<ArrayList<Data>> = _gitUsers

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _gitUsers.postValue(ArrayList(gitUserDBRepo.selectAll()))
        }
    }

    fun update() {
        viewModelScope.launch(Dispatchers.IO) {
            _gitUsers.postValue(ArrayList(gitUserDBRepo.selectAll()))
        }
    }
}

class DatabaseViewModelFactory(
    private val gitUserDBRepo : GitUserDBRepository
    ): ViewModelProvider.Factory {
    override fun <T: ViewModel?> create(modelClass: Class<T>) : T {
        if(modelClass.isAssignableFrom(DatabaseViewModel::class.java)) {
            return DatabaseViewModel(gitUserDBRepo) as T
        }
        throw IllegalArgumentException("Not Found ViewModel Class!")
    }
}