package com.example.composerdemo1.domain.usecases.cart

import com.example.composerdemo1.domain.models.CartItem
import com.example.composerdemo1.domain.ports.CartRepositoryPort
import kotlinx.coroutines.flow.Flow

class GetCartItems(
    private val repository: CartRepositoryPort
) {

    fun getCartItems(): Flow<List<CartItem>> {
        return repository.getCartItems()
    }
}