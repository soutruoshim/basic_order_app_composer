package com.example.composerdemo1.domain.usecases.product

import com.example.composerdemo1.domain.models.Category
import com.example.composerdemo1.domain.models.Product
import com.example.composerdemo1.domain.ports.ProductRepositoryPort
import kotlinx.coroutines.flow.Flow

class GetProductList(
    private val repository: ProductRepositoryPort
) {

    fun getProducts(): Flow<List<Product>> {
        return repository.getProducts()
    }

    fun getProducts(category: Category): Flow<List<Product>> {
        return repository.getProducts(category)
    }
}