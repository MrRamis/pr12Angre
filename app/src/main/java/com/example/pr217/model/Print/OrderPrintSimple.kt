package Pr1.Pr5.model.Print

import Pr1.Pr5.model.Or.Order

class OrderPrintSimple: OrderPrint {
    override fun print(i : Order){
        println("${i.orderName.lastName} ${i.orderName.lastName} ${i.orderPrice.price}")
    }
}