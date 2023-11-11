package com.example.pr217.viewModel

import Pr1.Pr5.model.List.OrdersListSimple
import androidx.lifecycle.ViewModel
import com.example.pr217.model.data.MainDb
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainAVM @Inject constructor(val listOrders : OrdersListSimple): ViewModel() {
}