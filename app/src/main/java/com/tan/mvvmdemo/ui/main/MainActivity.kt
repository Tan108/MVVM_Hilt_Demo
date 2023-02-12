package com.tan.mvvmdemo.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.tan.mvvmdemo.R
import com.tan.mvvmdemo.data.repository.MainRepository
import com.tan.mvvmdemo.databinding.ActivityMainBinding
import com.tan.mvvmdemo.ui.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.getPosts().observe(this) {
            binding.data ="Title : \n"+ it[0].title +"\nBody : \n"+ it[0].body
        }

    }
}