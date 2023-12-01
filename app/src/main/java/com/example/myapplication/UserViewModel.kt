package com.example.myapplication

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(val repo: UserRepository): ViewModel() {
    val TAG = "USERVIEWMODEL"

    val loginRequest = LoginRequest("demo", "12345")
    val gasError = mutableStateOf(Boolean)
    val errorText = mutableStateOf("")


    val login = mutableStateOf("")
    val password = mutableStateOf("")
    val name = mutableStateOf("")
    var isUserInitialized = mutableStateOf(false)
    var isLoginScreen = mutableStateOf(false)

    fun confirmAuth() {
        viewModelScope.launch {
            repo.userToken = RetrofitClient.exampleService.loginUser(login.value,password.value)
            repo.list = RetrofitClient.exampleService.getRandomInfo(repo.userToken)
        
/*            val loginResponse = RetrofitClient.easyPayService.login(RetrofitClient.API_KEY,1, loginRequest)

            // Assuming you have obtained a token from the login response
            val token = loginResponse.body()?.token ?: ""

            val paymentsResponse = RetrofitClient.easyPayService.getPayments(token, RetrofitClient.API_KEY)
            Log.d(TAG,"${loginResponse.body()}")
            Log.d(TAG,"${loginResponse.message()}")
            Log.d(TAG,"${loginResponse.errorBody()}")
            Log.d(TAG,"$loginResponse")
            Log.d(TAG,"$token")
            Log.d(TAG,"$paymentsResponse")
            if (paymentsResponse.isSuccessful) {
                val responseBody = paymentsResponse.body()
                val jsonData = responseBody?.data

                Log.d(TAG,"$responseBody")
            } else {

            }*/
        }
    }
}