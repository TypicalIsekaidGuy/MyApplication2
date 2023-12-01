package com.example.myapplication

import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel

class MainViewModel(repo: UserRepository): ViewModel() {
        val list by repo.list

}