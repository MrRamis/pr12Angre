package com.example.pr217.navigation

sealed class Screens(val route: String) {
    object Main: Screens("mainActivity")
    object AddOrder: Screens("addActivity")
    object UpdateOrder: Screens("UpdateOrderActivity/")
    object GetOrder: Screens("GetOrderActivity/")
}