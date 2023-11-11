package Pr1.Pr5.model.Checking

import javax.inject.Inject

class OrderCheckingPriceSimple @Inject constructor() : OrderCheckingPrice {
    override fun checking(price: String?): Boolean {

        if (price == null)
            return false
        else {
            val re = price.toIntOrNull()
            if (re != null) {
                if (re < 0) {
                    return false
                }
            } else return false
        }
        return true
    }
}