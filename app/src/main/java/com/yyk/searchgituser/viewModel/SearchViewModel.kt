package com.yyk.searchgituser.viewModel

import androidx.lifecycle.*
import com.yyk.searchgituser.data.Data
import com.yyk.searchgituser.data.ResultStatus
import com.yyk.searchgituser.repository.GitUserAPIRepository
import com.yyk.searchgituser.repository.GitUserDBRepository
import dagger.hilt.android.lifecycle.HiltViewModel
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

    fun getUserData() {
        viewModelScope.launch {
            val result = gitUserAPIRepo.getGitUsers(enterTxt.value)
            _gitUsers.value = result.items
        }
    }

    fun changeLikeStatus(position: Int) = liveData {
        emit(ResultStatus.Loading)
        try {
            val gitUserDB = _gitUsers.value?.get(position)
            emit(ResultStatus.Success(gitUserDBRepo.insert(gitUserDB)))
        }catch(e: Exception) {
            emit(ResultStatus.Error(e))
        }
    }
}

//class SearchViewModelFactory(
//    private val gitUserAPIRepo: GitUserAPIRepository,
//    private val gitUserDBRepo: GitUserDBRepository
//): ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if(modelClass.isAssignableFrom(SearchViewModel::class.java)) {
//            return SearchViewModel(gitUserAPIRepo, gitUserDBRepo) as T
//        }
//        throw IllegalArgumentException("Not found ViewModel Class!")
//    }
//}