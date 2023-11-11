package Pr1.Pr5.model.Checking

import javax.inject.Inject

class OrderCheckingDiscountSimple @Inject constructor() : OrderCheckingDiscount {
    override fun checking(discount: String?): Boolean {
        if (discount == null)
            return false
        else {
            val re = discount.toIntOrNull()
            if (re != null) {
                if (discount.equals(0..100)) {
                    return false
                }
            } else return false
        }
       return true
    }
}