package com.example.composerdemo1.data.repositories

import com.example.composerdemo1.data.datasources.CategoryDataSource
import com.example.composerdemo1.domain.models.Category
import com.example.composerdemo1.domain.ports.CategoryRepositoryPort
import kotlinx.coroutines.flow.Flow

class CategoryRepository(
    private val categoryDataSource: CategoryDataSource
) : CategoryRepositoryPort {

    override fun getCategories(): Flow<List<Category>> {
        return categoryDataSource.getCategories()
    }
}