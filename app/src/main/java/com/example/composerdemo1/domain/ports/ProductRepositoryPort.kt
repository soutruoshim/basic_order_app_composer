package com.example.composerdemo1.domain.ports

import com.example.composerdemo1.domain.models.Category
import com.example.composerdemo1.domain.models.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepositoryPort {
    fun getProducts(): Flow<List<Product>>
    fun getProducts(category: Category): Flow<List<Product>>
}