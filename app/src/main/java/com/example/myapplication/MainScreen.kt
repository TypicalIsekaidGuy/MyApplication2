package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel){
    Column(){

        TopMainBar()
        PaymentsList(list = mainViewModel)
    }
}
@Composable
fun TopMainBar(){
    Text(modifier = Modifier,text = "See all your purchases", fontSize = 24.sp)
}
@Composable
fun PaymentsList(list: List<Payment>){
    LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)){
        item{
            Row(){
                Text(text = "accountId")
                Text(text = "product")
                Text(text = "payment method")
                Text(text = "payment")
                Text(text = "date")
            }
        }
        item(list.size){
            PaymentItem(list[it])
        }
    }
}
@Composable
fun PaymentItem(payment: Payment){
    Row(){
        Text(text = "${payment.accountId}")
        Text(text = "${payment.product}")
        Text(text = "${payment.paymentType}")
        Text(text = "${payment.payment}${payment.currency}")
        Text(text = "${payment.payDate}")
    }
}