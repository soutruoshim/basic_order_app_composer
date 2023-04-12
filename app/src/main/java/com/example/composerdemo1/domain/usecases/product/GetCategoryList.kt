package com.example.composerdemo1.domain.usecases.product

import com.example.composerdemo1.domain.models.Category
import com.example.composerdemo1.domain.ports.CategoryRepositoryPort
import kotlinx.coroutines.flow.Flow

class GetCategoryList(
    private val repository: CategoryRepositoryPort
) {

    fun getCategories(): Flow<List<Category>> {
        return repository.getCategories()
    }
}