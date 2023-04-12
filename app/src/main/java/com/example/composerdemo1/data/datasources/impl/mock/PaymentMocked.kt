package com.example.composerdemo1.data.datasources.impl.mock

import com.example.composerdemo1.data.datasources.PaymentDataSource
import com.example.composerdemo1.domain.models.order.Order
import com.example.composerdemo1.domain.models.order.Payment
import com.example.composerdemo1.domain.models.order.PaymentResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class PaymentMocked : PaymentDataSource {

    override suspend fun doPayment(order: Order): PaymentResult {
        return withContext(Dispatchers.IO) {
            delay(4000)
            PaymentResult(
                status = true,
                payment = Payment(
                    status = "SUCCESS",
                    reference = "123ABC")
            )
        }
    }
}