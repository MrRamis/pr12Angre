package Pr1.Pr5.model.Scanner

import Pr1.Pr5.model.Checking.OrderCheckingDeliveryAddress
import Pr1.Pr5.model.Checking.OrderCheckingDeliveryAddressSimple
import Pr1.Pr5.model.Checking.OrderCheckingDiscount
import Pr1.Pr5.model.Checking.OrderCheckingDiscountSimple
import Pr1.Pr5.model.Checking.OrderCheckingName
import Pr1.Pr5.model.Checking.OrderCheckingNameSimple
import Pr1.Pr5.model.Checking.OrderCheckingPrice
import Pr1.Pr5.model.Checking.OrderCheckingPriceSimple
import Pr1.Pr5.model.Or.Order
import Pr1.Pr5.model.Ord.OrderFactory
import Pr1.Pr5.model.Ord.OrderFactorySimple
import javax.inject.Inject

class OrderScannerSimple @Inject constructor() {
    val orderFactory: OrderFactorySimple = OrderFactorySimple()
    val orderCheckingName: OrderCheckingName = OrderCheckingNameSimple()
    val orderCheckingDiscount: OrderCheckingDiscount = OrderCheckingDiscountSimple()
    val orderCheckingPrice: OrderCheckingPrice = OrderCheckingPriceSimple()
    val orderCheckingDeliveryAddress: OrderCheckingDeliveryAddress = OrderCheckingDeliveryAddressSimple()
    fun Input(
        id: String,
        name: String,
        lastName: String,
        surmName: String,
        deliveryAddress: String,
        price: String,
        discount: String
    ): Order? {

        if (orderCheckingName.checking(  name,
                lastName,
                surmName
            ) && orderCheckingDeliveryAddress.checking(deliveryAddress) && orderCheckingPrice.checking(
                price
            ) && orderCheckingDiscount.checking(discount)
        )
            return orderFactory.create(id,lastName, name, surmName, price, discount, deliveryAddress)
        return null
    }
}
