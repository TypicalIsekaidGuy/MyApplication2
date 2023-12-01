package com.example.myapplication

import androidx.compose.runtime.mutableStateOf


class UserRepository {
    lateinit var userToken: String
    var list = mutableStateOf(listOf<Payment>())
}