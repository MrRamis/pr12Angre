package com.example.pr217.view

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.pr217.navigation.Screens
import com.example.pr217.viewModel.GetOrderAVM


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetOrderActivity(navController: NavController, id:String,vm:GetOrderAVM) {
     vm.id = id
    var imageUri by remember{ mutableStateOf<Uri?>(vm.order().imageUri)}
    Scaffold(
        bottomBar = {
            BottomAppBar {
                Spacer(Modifier.weight(1f, true))
                Button(onClick = {navController.navigate("${Screens.UpdateOrder.route}${id}") }, content = { Text(text = "Updete order") })
                Spacer(Modifier.weight(1f, true))
                Button(onClick = {
                    navController.navigate(Screens.Main.route)
                    vm.dellOrder()
                                 }, content = { Text(text = "Delate order") })
                Spacer(Modifier.weight(1f, true))
            }
        }
    ) {
        Column {
            vm.order().orderName.let { it1 -> Text(text = it1.name) }
            vm.order().orderName.let { it1 -> Text(text = it1.lastName) }
            vm.order().orderName.let { it1 -> Text(text = it1.surmName) }
            Text(text = vm.order().orderPrice.price.toString())
            Text(text = vm.order().orderDiscount.discount.toString())
            vm.order().orderDeliveryAddress.deliveryAddress.let { it1 -> Text(text = it1) }
            Log.d("mgkit2",vm.order().imageUri.toString())
            vm.order().imageUri.let { it1 -> Image(painter = rememberAsyncImagePainter(it1), contentDescription = "")}
            //Image(painter = rememberAsyncImagePainter(imageUri), contentDescription = "")
        }
    }
}