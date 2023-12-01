package com.example.myapplication

sealed class Screen(val route: String){
    object UserScreen: Screen("user_screen")
    object MainScreen: Screen("main_screen")

    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach {arg ->
                append("/$arg")
            }
        }
    }
}