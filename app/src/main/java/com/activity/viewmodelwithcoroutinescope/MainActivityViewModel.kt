package com.activity.viewmodelwithcoroutinescope

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.activity.viewmodelwithcoroutinescope.Model.User
import com.activity.viewmodelwithcoroutinescope.Model.UserRepository
import kotlinx.coroutines.*

//extends viewModel class
class MainActivityViewModel : ViewModel(){

    private var userRepository = UserRepository()
    var users : MutableLiveData<List<User>> = MutableLiveData()


    /*viewModelScope automatically handle cancellation when the viewModel
    onCleared() is called*/
   /* a viewModelScope is define on each viewModel in our app in any coroutine
    launch in this scope will be automatically cancelif the viewModel is cleared*/
    fun getUserData(){
        viewModelScope.launch {
            var result : List<User>? = null
            withContext(Dispatchers.IO){
                result = userRepository.getUser()
            }
            //set list of user as value of mutable list of user
            users.value = result
        }
    }


}