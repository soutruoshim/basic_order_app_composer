package com.example.composerdemo1.domain.usecases.cart

import com.example.composerdemo1.domain.models.CartItem
import com.example.composerdemo1.domain.ports.CartRepositoryPort
import kotlinx.coroutines.flow.Flow

class RemoveItemCart(
    private val repository: CartRepositoryPort
) {
    fun removeItemCart(cartItem: CartItem): Flow<List<CartItem>> {
        return repository.removeItemCart(cartItem)
    }
}