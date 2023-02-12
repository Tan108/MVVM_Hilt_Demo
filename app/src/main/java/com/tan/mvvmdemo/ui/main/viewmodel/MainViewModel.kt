package com.tan.mvvmdemo.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tan.mvvmdemo.data.model.Posts
import com.tan.mvvmdemo.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private var mainRepository: MainRepository) : ViewModel(){

     fun getPosts():LiveData<List<Posts>>{
         val postsListLiveDta = MutableLiveData<List<Posts>>()
        viewModelScope.launch {
           postsListLiveDta.value =  mainRepository.getPosts().body()

          /*  mainRepository.getPosts().enqueue(object : retrofit2.Callback<List<Posts>>{
                override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                    Log.d("Tag", "Response is ${response.body()}")
                    postsListLiveDta.value = response.body()
                }

                override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                   Log.d("Tag", "Error Occurred ${t.message} ")
                }
            })*/
        }
         return postsListLiveDta;
    }



}