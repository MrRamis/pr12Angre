package com.example.pr217.view

import android.annotation.SuppressLint
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.pr217.viewModel.UpdateOrderAVM

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateOrderActivity(navController: NavController, id: String, vm:UpdateOrderAVM) {
    vm.id = id
    var Name by remember { mutableStateOf(vm.order().orderName.name) }
    var lastName by remember { mutableStateOf(vm.order().orderName.lastName) }
    var surmName by remember { mutableStateOf(vm.order().orderName.surmName) }
    var Price by remember { mutableStateOf(vm.order().orderPrice.price.toString()) }
    var Discount by remember { mutableStateOf(vm.order().orderDiscount.discount.toString()) }
    var DeliveryAddress by remember { mutableStateOf(vm.order().orderDeliveryAddress.deliveryAddress) }
    var imageUri by remember{ mutableStateOf<Uri?>(vm.order().imageUri)}
    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        imageUri = uri
    }
    Scaffold(
        topBar = {
            Text(text = "")

        },

        bottomBar = {
            BottomAppBar {
                Spacer(Modifier.weight(1f, true))
                Button(onClick = {vm.updateOrder(Name,lastName,surmName, DeliveryAddress,Price,Discount,imageUri) }, content = { Text(text = "Update") })
                Spacer(Modifier.weight(1f, true))
                Button(onClick = {launcher.launch("image/*")}, content = { Text(text = "AddImage") })
                Spacer(Modifier.weight(1f, true))
            }
        }
    ) {
        Column {
            TextField(value = Name, onValueChange = { Name = it })
            TextField(value = lastName, onValueChange = { lastName = it })
            TextField(value = surmName, onValueChange = { surmName = it })
            TextField(value = Price, onValueChange = { Price = it },keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone))
            TextField(value = Discount, onValueChange = { Discount = it },keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone))
            TextField(value = DeliveryAddress, onValueChange = { DeliveryAddress = it })
            Image(painter = rememberAsyncImagePainter(imageUri), contentDescription = "")
        }
    }
}