package com.example.myapplication

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

/*data class ApiResponse<T>(val data: T?)*/

interface ApiService {
    @FormUrlEncoded
    @POST("express/oauth/token")
    suspend fun getAccessToken(
        @Field("client_secret") clientSecret: String,
        @Field("code") code: String,
        @Field("grant_type") grantType: String = "authorization_code"
    )/*: AccessTokenResponse*/

    @FormUrlEncoded
    @POST("v1/accounts")
    suspend fun createAccount(
        @Field("type") type: String = "standard",
        @Field("country") country: String = "US",
        @Field("email") email: String,
        @Field("business_type") businessType: String = "individual"
    )/*: CreateAccountResponse*/
}
/*
interface ApiService {
    @POST("login")
    suspend fun login(
        @Header("app-key") apiKey: String,
        @Header("v") version: Int=1,
        @Body request: LoginRequest
    ): Response<LoginResponse>

    @GET("payments")
    suspend fun getPayments(
        @Header("token") token: String,
        @Header("app-key") apiKey: String
    ): Response<ApiResponse<JsonElement>>
}
*/
