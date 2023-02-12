package com.tan.mvvmdemo.data.repository

import com.tan.mvvmdemo.data.api.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(private var apiService: ApiService) {

    suspend fun getPosts() = apiService.getPosts()
}