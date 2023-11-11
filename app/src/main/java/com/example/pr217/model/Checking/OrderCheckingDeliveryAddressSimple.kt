package Pr1.Pr5.model.Checking

import javax.inject.Inject

class OrderCheckingDeliveryAddressSimple @Inject constructor() : OrderCheckingDeliveryAddress {
    override fun checking(deliveryAddress: String?): Boolean {
        if (deliveryAddress == null)
            return false
        return  true
    }
}