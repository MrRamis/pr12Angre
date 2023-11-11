package Pr1.Pr5.model.Ord

import Pr1.Pr5.model.Or.Order

interface OrderFactory {
    fun create(id :String,lastName:String, name:String, surmName:String, price:Int, discount:Int, deliveryAddress:String): Order
    fun create(id :String,lastName:String, name:String, surmName:String, price:String, discount:String, deliveryAddress:String): Order
}

