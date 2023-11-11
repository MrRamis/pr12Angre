package com.example.pr217.model.repositories

import Pr1.Pr5.model.Or.Order
import Pr1.Pr5.model.Or.OrderDeliveryAddress
import Pr1.Pr5.model.Or.OrderDiscount
import Pr1.Pr5.model.Or.OrderName
import Pr1.Pr5.model.Or.OrderPrice
import android.app.Application
import android.net.Uri
import androidx.core.net.toUri
import com.example.pr217.model.data.MainDb
import com.example.pr217.model.data.OrdersEntity
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class  OrdersRepository @Inject constructor(val application: Application) {
    private val db = MainDb.createDataBase(application)

    fun getOrgers(): List<Order> {
        var ordersEntity: List<OrdersEntity>? = null
        runBlocking {
            launch {
                ordersEntity = db.dao().getAllOrders()
            }
        }
        var re = mutableListOf<Order>()
        val r = ordersEntity?.map {
            it.let { it1 ->
                Order(
                    id = it1.id,
                    OrderName(
                        it.name, it.lastName, it.surmName
                    ),
                    OrderPrice(it.price),
                    OrderDiscount(it.discount),
                    OrderDeliveryAddress(it.deliveryAddress),
                    it.uri?.toUri()
                )
            }
        }
        if (!r.isNullOrEmpty())
            re.addAll(r)
        return re.toList()
    }

    fun addOrgers(order: Order) {
        runBlocking {
            launch {
                db.dao().insertOrder(
                    OrdersEntity(
                        order.id,
                        order.orderName.name,
                        order.orderName.lastName,
                        order.orderName.surmName,
                        order.orderDiscount.discount,
                        order.orderDeliveryAddress.deliveryAddress,
                        order.orderPrice.price,
                        order.imageUri.toString()
                    )
                )

            }
        }
    }

    fun deleteOrder(order: Order) {
        runBlocking {
            launch {
                db.dao().deleteOrder(
                    OrdersEntity(
                        order.id,
                        order.orderName.name,
                        order.orderName.lastName,
                        order.orderName.surmName,
                        order.orderDiscount.discount,
                        order.orderDeliveryAddress.deliveryAddress,
                        order.orderPrice.price,
                        order.imageUri.toString()
                    )
                )
            }
        }
    }
}
