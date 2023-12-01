package com.example.myapplication

// Data class for login request
data class LoginRequest(val login: String, val password: String)



data class StripeTokenResponse(
    val access_token: String,
    val stripe_user_id: String
)
