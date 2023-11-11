package com.example.pr217.viewModel

import Pr1.Pr5.model.List.OrdersListSimple
import Pr1.Pr5.model.Scanner.OrderScannerSimple
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pr217.view.orderItem
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject


@HiltViewModel
class AddOrderAVM@Inject constructor(val listOrders : OrdersListSimple):  ViewModel() {

    fun addOrder(
        name: String,
        lastName: String,
        surmName: String,
        deliveryAddress: String,
        price: String,
        discount: String,
        uri: Uri?
    ) {
        val order = OrderScannerSimple().Input(
            UUID.randomUUID().toString(),
            name,
            lastName,
            surmName,
            deliveryAddress,
            price,
            discount
        )
        if (order != null) {
            order.imageUri = uri
            listOrders.add(order = order)
        }
    }
}