package com.tan.mvvmdemo.data.api

import androidx.lifecycle.LiveData
import com.tan.mvvmdemo.data.model.Posts
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("posts")
     suspend fun getPosts(): Response<List<Posts>>

}