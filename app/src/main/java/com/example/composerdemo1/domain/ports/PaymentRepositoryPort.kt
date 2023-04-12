package com.example.composerdemo1.domain.ports

import com.example.composerdemo1.domain.models.order.Order
import com.example.composerdemo1.domain.models.order.PaymentResult

interface PaymentRepositoryPort {
    suspend fun orderPayment(order: Order): PaymentResult
}