package com.example.composerdemo1.data.datasources.impl.remote

import com.example.composerdemo1.data.datasources.CategoryDataSource
import com.example.composerdemo1.domain.models.Category
import kotlinx.coroutines.flow.Flow

class CategoryRemote: CategoryDataSource {
    override fun getCategories(): Flow<List<Category>> {
        TODO("Not yet implemented")
    }
}