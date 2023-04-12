package com.example.composerdemo1.domain.ports

import com.example.composerdemo1.domain.models.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepositoryPort {
    fun getCategories(): Flow<List<Category>>
}