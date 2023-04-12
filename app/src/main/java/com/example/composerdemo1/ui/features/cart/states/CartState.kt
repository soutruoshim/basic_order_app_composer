package com.example.composerdemo1.ui.features.cart.states

import com.example.composerdemo1.domain.models.CartItem

data class CartState(
    val cartItems: List<CartItem> = emptyList()
)

val CartState.readyForCheckout: Boolean
    get() = cartItems.isNotEmpty()