package com.example.composerdemo1.data.repositories

import com.example.composerdemo1.data.datasources.CartDataSource
import com.example.composerdemo1.domain.models.CartItem
import com.example.composerdemo1.domain.ports.CartRepositoryPort
import kotlinx.coroutines.flow.Flow

class CartRepository(
    private val cartDataSource: CartDataSource
): CartRepositoryPort {
    override fun saveItemCart(cartItem: CartItem): Flow<List<CartItem>> {
        return cartDataSource.saveItemCart(cartItem)
    }

    override fun removeItemCart(cartItem: CartItem): Flow<List<CartItem>> {
        return cartDataSource.removeItemCart(cartItem)
    }

    override fun getCartItems(): Flow<List<CartItem>> {
        return cartDataSource.getCartItems()
    }

    override fun updateCartItems(cartItem: CartItem, operator: Int): Flow<List<CartItem>> {
        return cartDataSource.updateCartItems(cartItem, operator)
    }
}