package Pr1.Pr5.model.List

import Pr1.Pr5.model.Or.Order
import android.util.Log
import com.example.pr217.model.repositories.OrdersRepository
import javax.inject.Inject
import javax.inject.Singleton


/** holder of List
 *
 */
@Singleton
class OrdersListSimple @Inject constructor(val repository: OrdersRepository) : OrdersList {
    private val list = mutableListOf<Order>()

    override fun add(order: Order) {
        list.add(order)
        repository.addOrgers(order)
    }
    override fun delete(order: Order) {
        list.remove(order)
        repository.deleteOrder(order)
    }

    override fun update(order: Order,orderNew: Order) {
        list.set( list.indexOf(order) , orderNew)
        repository.addOrgers(orderNew)
    }

    override fun delete(index: Int) {
        repository.deleteOrder(getOrdet(index))
        list.remove(getOrdet(index))
    }
    override fun delete(id: String) {
        repository.deleteOrder(list.filter { it.id == id }.first())
        list.remove(list.filter { it.id == id }.first())
    }

    override fun getList(): List<Order> {
        return list.toList()
    }

    override fun sortingList(): List<Order> {
        return list.sortedBy { t-> t.orderDiscount.discount } .toList()
    }

    override fun getOrdet(index: Int):Order {
        return list[index]
    }

    init {
        list.addAll(repository.getOrgers())
        Log.d("MyTeg", this.hashCode().toString())
    }
}