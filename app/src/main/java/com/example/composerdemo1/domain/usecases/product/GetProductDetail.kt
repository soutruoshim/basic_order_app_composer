package com.example.composerdemo1.domain.usecases.product

import com.example.composerdemo1.domain.ports.ProductRepositoryPort

class GetProductDetail(
    private val repository: ProductRepositoryPort
)