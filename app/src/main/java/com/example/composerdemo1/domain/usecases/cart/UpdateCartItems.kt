package com.example.composerdemo1.domain.usecases.cart

import com.example.composerdemo1.domain.models.CartItem
import com.example.composerdemo1.domain.ports.CartRepositoryPort
import kotlinx.coroutines.flow.Flow

class UpdateCartItems(
    private val repository: CartRepositoryPort
) {
    fun updateCartItems(cartItems: CartItem, operator: Int): Flow<List<CartItem>> {
        return repository.updateCartItems(cartItems, operator)
    }
}