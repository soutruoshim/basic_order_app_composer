package com.example.composerdemo1.data.datasources

import com.example.composerdemo1.domain.models.order.Order
import com.example.composerdemo1.domain.models.order.PaymentResult

interface PaymentDataSource {
    suspend fun doPayment(order: Order): PaymentResult
}