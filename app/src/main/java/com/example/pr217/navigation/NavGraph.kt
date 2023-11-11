package com.example.pr217.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pr217.ViwModelData
import com.example.pr217.mainActivity
import com.example.pr217.view.addActivity
import com.example.pr217.view.GetOrderActivity
import com.example.pr217.view.UpdateOrderActivity
import java.io.File

@Composable
fun NavGraph(
    filesDir: File, context: Context, navController: NavHostController, viwModelData: ViwModelData
)
    {
        NavHost(
            navController = navController,
            startDestination = Screens.Main.route
        )
        {
            composable(route = Screens.Main.route) {
                  mainActivity(navController,viwModelData.mainAVM)
            }
            composable(route = Screens.AddOrder.route) {
                addActivity(filesDir,context,navController,viwModelData.addOrderAVM)
            }
            composable(
                route = Screens.UpdateOrder.route + "{id}",
                arguments = listOf(navArgument("id") {
                    type = NavType.StringType
                })
            ) {
                val id = requireNotNull(it.arguments).getString("id")

                if (id != null) {
                    UpdateOrderActivity(navController, id,viwModelData.updateOrderAVM)
                }
            }
            composable(
                route = Screens.GetOrder.route + "{id}",
                arguments = listOf(navArgument("id") {
                    type = NavType.StringType
                })
            ) {
                val id = requireNotNull(it.arguments).getString("id")
                if (id != null)
                    GetOrderActivity(navController, id,viwModelData.getOrderAVM)
            }
        }
    }
