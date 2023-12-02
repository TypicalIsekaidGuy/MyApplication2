package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel){
    val list = mainViewModel.list
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 32.dp), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)) {

            TopMainBar()

            PaymentsList(list = list)
        }
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

            Row(modifier = Modifier.height(IntrinsicSize.Min).fillMaxWidth()) {
                Box(modifier = Modifier.size(60.dp).align(Alignment.CenterVertically)) {
                    Text(text = "accountId", modifier = Modifier.align(Alignment.Center), fontSize = 12.sp)
                }
                Box(modifier = Modifier.size(65.dp).align(Alignment.CenterVertically)) {
                    Text(text = "product", modifier = Modifier.align(Alignment.Center), fontSize = 16.sp)
                }
                Box(modifier = Modifier.size(70.dp).align(Alignment.CenterVertically).padding(8.dp)) {
                    Text(text = "payment method", modifier = Modifier.align(Alignment.Center), fontSize = 12.sp)
                }
                Box(modifier = Modifier.size(100.dp).align(Alignment.CenterVertically)) {
                    Text(text = "payment", modifier = Modifier.align(Alignment.Center), fontSize = 12.sp)
                }
                Box(modifier = Modifier.size(60.dp).align(Alignment.CenterVertically).padding(12.dp)) {
                    Text(text = "date", modifier = Modifier.align(Alignment.Center), fontSize = 12.sp)
                }
            }
        }
        items(list.size){
            PaymentItem(payment = list[it])
        }
    }
}
@Composable
fun PaymentItem(payment: Payment){
    Row(modifier = Modifier.height(IntrinsicSize.Min)) {
        Box(modifier = Modifier.size(60.dp).align(Alignment.CenterVertically)) {
            Text(text = "${payment.accountId}", modifier = Modifier.align(Alignment.Center))
        }
        Spacer(modifier = Modifier.width(10.dp))
        Box(modifier = Modifier.size(65.dp).align(Alignment.CenterVertically)) {
            Text(text = "${payment.product}", modifier = Modifier.align(Alignment.Center))
        }
        Spacer(modifier = Modifier.width(10.dp))
        Box(modifier = Modifier.size(70.dp).align(Alignment.CenterVertically)) {
            Text(text = "${payment.paymentType}", modifier = Modifier.align(Alignment.Center))
        }
        Spacer(modifier = Modifier.width(10.dp))
        Box(modifier = Modifier.size(100.dp).align(Alignment.CenterVertically)) {
            Text(text = "${payment.payment}${payment.currency}", modifier = Modifier.align(Alignment.Center))
        }
        Spacer(modifier = Modifier.width(10.dp))
        Box(modifier = Modifier.size(80.dp).align(Alignment.CenterVertically)) {
            Text(text = "${payment.payDate}", modifier = Modifier.align(Alignment.Center))
        }
        Divider(color = Color.Black, thickness = 10.dp) // Add divider after each row

    }
}