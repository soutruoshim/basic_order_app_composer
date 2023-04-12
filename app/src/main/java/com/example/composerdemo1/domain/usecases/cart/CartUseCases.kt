package com.example.composerdemo1.domain.usecases.cart

data class CartUseCases (
    val saveItemCart: SaveItemCart,
    val removeItemCart: RemoveItemCart,
    val getCartItems: GetCartItems,
    val updateCartItems: UpdateCartItems
)