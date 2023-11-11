package Pr1.Pr5.model.List

import Pr1.Pr5.model.Or.Order
import javax.inject.Singleton

@Singleton
interface  OrdersList {
    fun add(order: Order)
    fun delete(order: Order)
    fun delete(index: Int)
    fun delete(id: String)
    fun update(order: Order, orderNew: Order)
    fun getList() :List<Order>
    fun sortingList() :List<Order>
    fun  getOrdet(index : Int): Order
}