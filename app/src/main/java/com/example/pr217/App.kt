package com.example.pr217

import Pr1.Pr5.model.List.OrdersListSimple
import android.app.Application
import com.example.pr217.model.data.MainDb
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import javax.inject.Singleton

@HiltAndroidApp
class App @Inject constructor() : Application() {
}