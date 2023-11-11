package Pr1.Pr5.model.Scanner

import Pr1.Pr5.model.Checking.OrderCheckingDeliveryAddress
import Pr1.Pr5.model.Checking.OrderCheckingDiscount
import Pr1.Pr5.model.Checking.OrderCheckingName
import Pr1.Pr5.model.Checking.OrderCheckingPrice
import Pr1.Pr5.model.Or.Order
import Pr1.Pr5.model.Ord.OrderFactory

interface OrderScanner {
   val orderFactory: OrderFactory
   val orderCheckingName: OrderCheckingName
   val orderCheckingDiscount: OrderCheckingDiscount
   val orderCheckingPrice: OrderCheckingPrice
   val orderCheckingDeliveryAddress: OrderCheckingDeliveryAddress
    fun Input(): Order?
}