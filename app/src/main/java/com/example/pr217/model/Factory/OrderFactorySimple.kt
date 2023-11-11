package Pr1.Pr5.model.Ord

import Pr1.Pr5.model.Or.*
import javax.inject.Inject

class OrderFactorySimple @Inject constructor() : OrderFactory {
    override fun create(id: String,lastName:String, name:String, surmName:String, price:Int, discount:Int, deliveryAddress:String): Order {
        val oName = OrderName(name,lastName,surmName)
        val oPrice = OrderPrice(price)
        val oDiscount = OrderDiscount(discount)
        val oDeliveryAddress = OrderDeliveryAddress(deliveryAddress)
        return Order(id,oName,oPrice,oDiscount,oDeliveryAddress)
    }

    override fun create(id: String,lastName:String, name:String, surmName:String, price:String, discount:String, deliveryAddress:String): Order {
        val oName = OrderName(name,lastName,surmName)
        val oPrice = OrderPrice(price.toInt())
        val oDiscount = OrderDiscount(discount.toInt())
        val oDeliveryAddress = OrderDeliveryAddress(deliveryAddress)
        return Order(id,oName,oPrice,oDiscount,oDeliveryAddress)
    }
}