package com.example.composerdemo1.data.repositories

import com.example.composerdemo1.data.datasources.ProductDataSource
import com.example.composerdemo1.domain.models.Category
import com.example.composerdemo1.domain.models.Product
import com.example.composerdemo1.domain.ports.ProductRepositoryPort
import kotlinx.coroutines.flow.Flow

class ProductRepository(
    private val productDataSource: ProductDataSource
) : ProductRepositoryPort {

    override fun getProducts(): Flow<List<Product>> {
        return productDataSource.getProducts()
    }

    override fun getProducts(category: Category): Flow<List<Product>> {
        return productDataSource.getProducts(category)
    }
}