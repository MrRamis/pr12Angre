package com.example.pr217.model.data

import android.net.Uri
import android.provider.ContactsContract.Data
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime
import javax.annotation.Nullable

@Entity
data class OrdersEntity(
    @PrimaryKey()
    val id:String,
    var date: Data,
    val time: Data,
    var objectName: String,
    var applicant: String,
    var content: String,
    var responseDate: Data,
    var response: String
)
