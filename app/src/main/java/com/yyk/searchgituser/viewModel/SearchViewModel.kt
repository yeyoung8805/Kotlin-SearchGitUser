package com.yyk.searchgituser.viewModel

import androidx.lifecycle.*
import com.yyk.searchgituser.data.Data
import com.yyk.searchgituser.data.ResultStatus
import com.yyk.searchgituser.repository.GitUserAPIRepository
import com.yyk.searchgituser.repository.GitUserDBRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import java.lang.IllegalArgumentException
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val gitUserAPIRepo: GitUserAPIRepository,
    private val gitUserDBRepo: GitUserDBRepository
) : ViewModel() {
    // TODO:: Retrofit SingleTon
    //
//    val enterTxt = MutableLiveData<String>("yeyoung") 처럼 초기화도 가능
    val enterTxt = MutableLiveData<String>()
    private val _gitUsers = MutableLiveData<ArrayList<Data>>()
    val gitUsers: LiveData<ArrayList<Data>> = _gitUsers

    init {
        enterTxt.value = "yeyoung"
    }

    fun getList() = gitUserAPIRepo.getGitUsers(enterTxt.value)
    fun changeStatus(position: Int) = gitUserDBRepo.changeLikeStatus(position, _gitUsers.value)
    fun filteringList(gitUserList: ArrayList<Data>) {
        viewModelScope.launch(Dispatchers.IO) {
            _gitUsers.postValue(gitUserDBRepo.filterSearchResult(gitUserList))
        }
    }

}