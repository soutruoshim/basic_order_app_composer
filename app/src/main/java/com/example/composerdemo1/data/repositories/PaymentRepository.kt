package com.example.composerdemo1.data.repositories

import com.example.composerdemo1.data.datasources.PaymentDataSource
import com.example.composerdemo1.domain.models.order.Order
import com.example.composerdemo1.domain.models.order.PaymentResult
import com.example.composerdemo1.domain.ports.PaymentRepositoryPort

class PaymentRepository(
    private val paymentDataSource: PaymentDataSource,
) : PaymentRepositoryPort {
    override suspend fun orderPayment(order: Order): PaymentResult {
        return paymentDataSource.doPayment(order)
    }
}