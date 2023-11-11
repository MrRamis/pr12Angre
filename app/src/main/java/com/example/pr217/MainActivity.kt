package com.example.pr217

import Pr1.Pr5.model.Or.Order
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pr217.navigation.NavGraph
import com.example.pr217.navigation.Screens
import com.example.pr217.viewModel.AddOrderAVM
import com.example.pr217.viewModel.GetOrderAVM
import com.example.pr217.viewModel.MainAVM
import com.example.pr217.viewModel.UpdateOrderAVM
import dagger.hilt.android.AndroidEntryPoint



class ViwModelData(
    val mainAVM : MainAVM,
    val updateOrderAVM : UpdateOrderAVM,
    val getOrderAVM : GetOrderAVM,
    val addOrderAVM : AddOrderAVM
)


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val mainAVM by viewModels<MainAVM>()
        val updateOrderAVM by viewModels<UpdateOrderAVM>()
        val getOrderAVM by viewModels<GetOrderAVM>()
        val addOrderAVM by viewModels<AddOrderAVM>()
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            NavGraph(filesDir,this@MainActivity,navController,ViwModelData(mainAVM,updateOrderAVM,getOrderAVM, addOrderAVM))
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainActivity(navController: NavController, vm : MainAVM) {
    Scaffold(
        topBar = {
            Text(text = "")
        },
        bottomBar = {
            BottomAppBar {
                Spacer(Modifier.weight(1f, true))
                Button(onClick = {   navController.navigate(Screens.AddOrder.route) }, content = { Text(text = "Add order") })
                Spacer(Modifier.weight(1f, true))
            }
        }
    )
    {
        listBoks(navController, vm.listOrders.getList())
    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun listBoks(navController: NavController,orders: List<Order>){
    LazyColumn() {
        items(orders) { order ->
            orderItem(navController,order, orders.indexOf(order))
        }
    }
}

@Composable
fun orderItem(navController: NavController,order: Order, index: Int ) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                 navController.navigate("${Screens.GetOrder.route}${order.id}")

            }
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(6f, true)
                    .padding(20.dp, 0.dp, 0.dp, 0.dp),
            ) {
                Text(
                    text = " ${order.orderName.name} ${order.orderDiscount.discount} ${order.orderPrice.price} ${order.orderDeliveryAddress.deliveryAddress}"
                )

            }
        }
    }
}
