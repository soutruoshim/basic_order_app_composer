package com.example.composerdemo1.domain.ports

import com.example.composerdemo1.domain.models.CartItem
import kotlinx.coroutines.flow.Flow

interface CartRepositoryPort {
    fun saveItemCart(cartItem: CartItem): Flow<List<CartItem>>
    fun removeItemCart(cartItem: CartItem): Flow<List<CartItem>>
    fun getCartItems(): Flow<List<CartItem>>
    fun updateCartItems(cartItem: CartItem, operator: Int): Flow<List<CartItem>>
}