package com.example.pr217.viewModel

import Pr1.Pr5.model.List.OrdersListSimple
import Pr1.Pr5.model.Scanner.OrderScannerSimple
import android.net.Uri
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UpdateOrderAVM @Inject constructor(val listOrders : OrdersListSimple): ViewModel() {
    var id:String =""
    fun order () = listOrders.getList().filter { it.id == id }.first()
    fun updateOrder(
        name: String,
        lastName: String,
        surmName: String,
        deliveryAddress: String,
        price: String,
        discount: String,
        imageUri: Uri?
    ){
        val order = OrderScannerSimple().Input(listOrders.getList().filter { it.id == id }.first().id,name, lastName, surmName, deliveryAddress, price, discount)
        if (order != null) {
            order.imageUri=imageUri
            listOrders.update(listOrders.getList().filter { it.id == id }.first(), order)
        }
    }
}