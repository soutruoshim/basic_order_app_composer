package com.example.composerdemo1.data.datasources.impl.local

import com.example.composerdemo1.data.datasources.CategoryDataSource
import com.example.composerdemo1.domain.models.Category
import kotlinx.coroutines.flow.Flow

class CategoryLocal: CategoryDataSource {
    override fun getCategories(): Flow<List<Category>> {
        TODO("Not yet implemented")
    }
}