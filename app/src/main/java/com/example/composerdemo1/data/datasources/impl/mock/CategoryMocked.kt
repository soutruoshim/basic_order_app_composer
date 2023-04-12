package com.example.composerdemo1.data.datasources.impl.mock

import com.example.composerdemo1.data.datasources.CategoryDataSource
import com.example.composerdemo1.domain.models.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CategoryMocked : CategoryDataSource {

    override fun getCategories(): Flow<List<Category>> {
        val categories: List<Category> =
            listOf(
                DataMocked.category1,
                DataMocked.category2,
                DataMocked.category3,
                DataMocked.category4
            )
        return flowOf(categories)
    }
}