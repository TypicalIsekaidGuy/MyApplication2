package com.example.myapplication

interface ExampleService {
    fun loginUser(login: String, password: String): String
    fun getRandomInfo(accountId: String): List<Payment>
}