package com.example.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.random.Random

// Inside your authentication manager or repository
object RetrofitClient {
    private const val BASE_URL = "https://api.stripe.com/v1/"

    val easyPayService: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiService::class.java)
    }
    val exampleService: ExampleService = ExampleServiceImpl()
    val possibleProducts = listOf<String>("Visa card","Ros card","Rostneft card","Php card","P2p card")
    val possiblePaymentType = listOf<String>("Visa card","Ros card","Rostneft card", "Pyypl")
    val possibleCurrency = listOf<Char>('$','Р','Э')
}

class ExampleServiceImpl : ExampleService {
    override fun loginUser(login: String, password: String): String {

/*
        TODO("Check if it is in datastore if no then create random data and random key to it")
*/
        val accountId = login + login.hashCode().toString()
        val list = mutableListOf<Payment>()
        for (i in 0..3){
            list.add(Payment(accountId,RetrofitClient.possibleProducts[Random.nextInt(5)],RetrofitClient.possiblePaymentType[Random.nextInt(4)],Random.nextFloat(),RetrofitClient.possibleCurrency[Random.nextInt(3)]))
        }
/*
        TODO("Save in datastore")
*/
        return accountId
    }

    override fun getRandomInfo(accountId: String): List<Payment> {
        val list = mutableListOf<Payment>()
        for (i in 0..3){
            list.add(Payment(accountId,RetrofitClient.possibleProducts[Random.nextInt(5)],RetrofitClient.possiblePaymentType[Random.nextInt(3)],Random.nextFloat(),RetrofitClient.possibleCurrency[Random.nextInt(3)]))
        }
/*
        TODO("Check if there is ")
*/
        return list.toList()
    }
}