package Pr1.Pr5.model.Checking

import javax.inject.Inject

class OrderCheckingNameSimple @Inject constructor() : OrderCheckingName {
    override fun checking(name: String?, lastName: String?, surmName: String?): Boolean {
        if (name == null || name == "")
            return false
        if (lastName == null || name == "")
            return false
        if (surmName == null)
            return false
        return true
    }
}