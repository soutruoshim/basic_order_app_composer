package com.example.composerdemo1.domain.usecases.payment

import com.example.composerdemo1.domain.models.order.Order
import com.example.composerdemo1.domain.models.order.PaymentResult
import com.example.composerdemo1.domain.ports.PaymentRepositoryPort

class DoPayment(
    private val repository: PaymentRepositoryPort,
) {

    suspend fun doPayment(order: Order): PaymentResult {
        return repository.orderPayment(order)
    }
}