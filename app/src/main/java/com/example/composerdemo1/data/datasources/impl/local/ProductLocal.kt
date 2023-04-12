package com.example.composerdemo1.data.datasources.impl.local

import com.example.composerdemo1.data.datasources.ProductDataSource
import com.example.composerdemo1.domain.models.Category
import com.example.composerdemo1.domain.models.Product
import kotlinx.coroutines.flow.Flow

class ProductLocal: ProductDataSource {
    override fun getProducts(): Flow<List<Product>> {
        TODO("Not yet implemented")
    }

    override fun getProducts(category: Category): Flow<List<Product>> {
        TODO("Not yet implemented")
    }
}