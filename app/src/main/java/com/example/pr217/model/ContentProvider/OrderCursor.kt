package com.example.pr217.model.ContentProvider

import Pr1.Pr5.model.Or.Order
import Pr1.Pr5.model.Or.OrderDeliveryAddress
import Pr1.Pr5.model.Or.OrderDiscount
import Pr1.Pr5.model.Or.OrderName
import Pr1.Pr5.model.Or.OrderPrice
import android.database.AbstractCursor
import android.net.Uri

class OrderCursor(val list: List<Order>) : AbstractCursor() {
    override fun getCount(): Int {
        return list.count()
    }

    override fun getColumnNames(): Array<String> = arrayOf("id", "orderName", "orderPrice", "orderDiscount", "orderDeliveryAddress", "imageUri")

    override fun getString(column: Int): String {
        return when (column){
            0 -> list[position].orderName.name
            1 -> list[position].orderName.lastName
            2 -> list[position].orderName.surmName
            3 -> list[position].orderDeliveryAddress.deliveryAddress
            4 -> list[position].imageUri.toString()
            else -> ""
        }
    }

    override fun getShort(column: Int): Short {
        TODO("Not yet implemented")
    }

    override fun getInt(column: Int): Int {
        return when (column){
            5 -> list[position].orderPrice.price
            6 -> list[position].orderDiscount.discount
            else -> 0
        }
    }

    override fun getLong(column: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getFloat(column: Int): Float {
        TODO("Not yet implemented")
    }

    override fun getDouble(column: Int): Double {
        TODO("Not yet implemented")
    }

    override fun isNull(column: Int): Boolean {
        TODO("Not yet implemented")
    }
}