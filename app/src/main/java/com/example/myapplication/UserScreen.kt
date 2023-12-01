package com.example.myapplication

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun UserScreen(navController: NavController, userViewModel: UserViewModel){
    val shouldNavigate by userViewModel.shouldNavigateToMainScreen
    var isInitialized by remember {
        userViewModel.isUserInitialized
    }
    var hasError = remember {
        userViewModel.gasError
    }
    var isLoginScreen = remember {
        userViewModel.isLoginScreen
    }
    var error by remember {
        userViewModel.errorText
    }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 24.dp)
        .padding(top = 32.dp), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)) {
                Text(text = "Welcome to MyApp",
                    fontSize = 32.sp
                )
                if(!isLoginScreen.value){
                EditTextLine(modifier = Modifier, text = userViewModel.login.value, onTextChanged = {userViewModel.login.value = it}, hint = "Login")
            }
                EditTextLine(modifier = Modifier, text = userViewModel.password.value, onTextChanged = {userViewModel.password.value = it}, hint = "Password")



            Column(verticalArrangement = Arrangement.spacedBy(8.dp),horizontalAlignment = Alignment.CenterHorizontally,){
                ConfirmButton {

                    userViewModel.confirmAuth()
                    Log.d("User","sss")
                    if (shouldNavigate) {
                        Log.d("User","sss")
                        navController.navigate(Screen.MainScreen.route) {
                            popUpTo(Screen.UserScreen.route) { inclusive = true }
                        }
                    }
                }
                if(false){
                    Text("$error", color = Color.Red)
                }
            }
        }

    }
}
@Composable
fun ConfirmButton(confirmAuth: () -> Unit) {
    Box(modifier = Modifier
        .clip(RoundedCornerShape(4.dp))
        .background(MaterialTheme.colorScheme.secondary)
        .height(48.dp)
        .width(256.dp)
        .clickable { confirmAuth() }){

        Text(text ="Confirm", fontSize = 16.sp, modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.Center), textAlign = TextAlign.Center)
    }
}
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun EditTextLine(
    modifier: Modifier = Modifier,
    text: String,
    onTextChanged: (String) -> Unit,
    hint: String,
    // icon: @DrawableRes Int
) {
    var isTextFieldFocused by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.Gray, shape = RoundedCornerShape(4.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier.weight(1f) // To make the Column take available horizontal space
        ) {
            Text(
                text = hint,
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            BasicTextField(
                value = text,
                onValueChange = {
                    onTextChanged(it)
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                        focusManager.clearFocus()
                    }
                ),
                textStyle = TextStyle(
                    fontSize = 16.sp
                ),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 8.dp, 0.dp, 0.dp)
                    .onFocusChanged { focusState ->
                        isTextFieldFocused = focusState.isFocused
                    }
            )
        }
    }
}
