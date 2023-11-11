package com.example.pr217.model.ContentProvider

import Pr1.Pr5.model.Or.Order
import Pr1.Pr5.model.Scanner.OrderScannerSimple
import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import androidx.core.net.toUri
import java.util.UUID

class MyContentProvider() : ContentProvider() {
    private val list = mutableListOf<Order>()

    override fun onCreate(): Boolean {
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        if ((projection==null)&&
            (selection==null)&&
            (selectionArgs==null)&&
            (sortOrder==null)){
            return OrderCursor(list.toList())
        }else return null
    }

    override fun getType(uri: Uri): String? {
        return "ram.object/ram.student"
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
      if (values != null) {
          val id = values["id"] as String
          val name = values["name"] as String
          val lastName = values["lastName"] as String
          val surmName = values["surmName"] as String
          val deliveryAddress = values["deliveryAddress"] as String
          val price = values["price"] as String
          val discoun = values["discoun"] as String
          val imageUri = values["imageUri"] as String
          val order = OrderScannerSimple().Input(
              id,
              name,
              lastName,
              surmName,
              deliveryAddress,
              price,
              discoun
          )
          order?.imageUri =  imageUri.toUri()
          if (order != null) {
              list.add(order)
          }
          return Uri.parse(uriPrefix+"/"+(list.size-1))
      }
        else return null
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        val count = list.size
        if(selectionArgs!= null){
            list.removeIf {
                it.id == selectionArgs[0]
            }
        }
        return count-list.size
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        TODO("Not yet implemented")
    }

    companion object{
        const val uriPrefix = "content:///ram/orde"
    }
}