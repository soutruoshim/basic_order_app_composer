package com.example.composerdemo1.ui.features.placeorder.states

import com.example.composerdemo1.domain.models.order.Payment
import com.example.composerdemo1.domain.models.order.PaymentResult

data class PaymentState(
    val paymentInformation: Payment = Payment(),
    val isLoading: Boolean = false,
    val paymentResult: PaymentResult? = null,
    val errorMessage: String? = null
)