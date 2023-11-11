package Pr1.Pr5.model.Or

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import javax.inject.Inject

data class Order @Inject constructor (
    var id:String = "",
    var orderName: OrderName,
    var orderPrice: OrderPrice,
    var orderDiscount: OrderDiscount,
    var orderDeliveryAddress: OrderDeliveryAddress,
    var imageUri: Uri? =null
)
