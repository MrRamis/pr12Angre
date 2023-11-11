package com.example.pr217.view

import Pr1.Pr5.model.List.OrdersList
import Pr1.Pr5.model.List.OrdersListSimple
import Pr1.Pr5.model.Or.Order
import android.annotation.SuppressLint
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
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Scaffold

import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainActivitibbb(navController: NavController){
  //  val orders : OrdersList = OrdersListSimple()
    Scaffold(
        topBar = {
            Text(text = "")

        },
        bottomBar = {
            BottomAppBar {
                Spacer(Modifier.weight(1f, true))
                Button(onClick = { /*TODO*/ }, content = { Text(text = "Add") })
                Spacer(Modifier.weight(1f, true))
            }
        },
       content = {
           Column {
               Divider()
             //  listBoks(orders = listOrders, navController = navController)
           }
       }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun listBoks(orders:OrdersList, navController: NavController){
    LazyColumn() {
        items(orders.getList()) { order ->
            orderItem(order, navController)
        }
    }
}

@Composable
fun orderItem(order: Order,navController: NavController) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                // navController.navigate(Screens.GetBook.route)
            }
    ) {
        //places its children in a horizontal sequence.
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            //places its children in a vertical sequence.
            Column(
                modifier = Modifier
                    .weight(6f, true)
                    .padding(20.dp, 0.dp, 0.dp, 0.dp),
            ) {
                //used to display text

                Text(
                    text = " ${order.orderName}"
                )

            }
        }
    }
}




/*
@Preview
@Composable
fun mainActivitiPreview(){
    val navController = rememberNavController()
    NavGraph(navController = navController)
    mainActiviti(navController)
}*/
