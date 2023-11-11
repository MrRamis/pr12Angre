package com.example.pr217.view

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.core.content.FileProvider
import android.content.Context

import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.pr217.viewModel.AddOrderAVM
import java.io.File


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun addActivity(filesDir: File,context: Context, navController: NavController, vm: AddOrderAVM) {
    var Name by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var surmName by remember { mutableStateOf("") }
    var Price by remember { mutableStateOf("") }
    var Discount by remember { mutableStateOf("") }
    var DeliveryAddress by remember { mutableStateOf("") }
    var imageUri by remember{ mutableStateOf<Uri?>(null)}


    val file = File(filesDir,"ter.jpg")
    val uri = FileProvider.getUriForFile(
        context,
        "ram.provider",
        file
    )

    var launcher = androidx.activity.compose.rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
        onResult = {

        }
    )



//    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
//        imageUri = uri
//        Log.d("mgkit",uri.toString())
//    }

    Scaffold(
        topBar = {
            Text(text = "")
        },
        bottomBar = {
            BottomAppBar {
                Spacer(Modifier.weight(1f, true))
                Button(onClick = {vm.addOrder(Name,lastName,surmName, DeliveryAddress,Price,Discount, uri = imageUri) }, content = { Text(text = "Add") })
                Spacer(Modifier.weight(1f, true))
                Button(onClick = {launcher.launch(uri)}, content = { Text(text = "AddImage") })
                Spacer(Modifier.weight(1f, true))
            }
        }
    ) {
        Column {
            TextField(value = Name, onValueChange = { Name = it })
            TextField(value = lastName, onValueChange = { lastName = it })
            TextField(value = surmName, onValueChange = { surmName = it })
            TextField(value = Price, onValueChange = { Price = it }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone))
            TextField(value = Discount, onValueChange = { Discount = it },keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone))
            TextField(value = DeliveryAddress, onValueChange = { DeliveryAddress = it })
            Image(painter = rememberAsyncImagePainter(imageUri), contentDescription = "")
        }
    }
}
