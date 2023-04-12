package com.example.composerdemo1.domain.models.order

data class PaymentResult(
    val status: Boolean,
    val payment: Payment
)