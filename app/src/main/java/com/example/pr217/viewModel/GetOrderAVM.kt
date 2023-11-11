package com.example.pr217.viewModel

import Pr1.Pr5.model.List.OrdersListSimple
import Pr1.Pr5.model.Or.Order
import Pr1.Pr5.model.Or.OrderDeliveryAddress
import Pr1.Pr5.model.Or.OrderDiscount
import Pr1.Pr5.model.Or.OrderName
import Pr1.Pr5.model.Or.OrderPrice
import androidx.lifecycle.ViewModel
import com.example.pr217.orderItem
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class GetOrderAVM @Inject constructor(val listOrders : OrdersListSimple): ViewModel() {
    var id:String = ""
    private val orderDefault = Order(id = "", orderName = OrderName("","",""),
        orderPrice =  OrderPrice(0),
        orderDiscount =  OrderDiscount(0),
        orderDeliveryAddress =  OrderDeliveryAddress("")  )
    fun order (): Order {
         val r :Order?
      val re = listOrders.getList()
        val d =re.filter { it.id == id }
        if (d.isNotEmpty())
            return  d.first()
       return orderDefault
    }




    fun dellOrder(){
        listOrders.delete( id)
    }
}

