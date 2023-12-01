package com.example.myapplication

import java.util.Currency

data class Payment(
    val accountId: String,
    val product: String,
    val paymentType: String,
    val payment: Float,
    val currency: Char = '$',
    val payDate: String = "1.12.2023"
)
