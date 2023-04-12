package com.example.composerdemo1.data.datasources

import com.example.composerdemo1.domain.models.Category
import kotlinx.coroutines.flow.Flow

interface CategoryDataSource {
    fun getCategories(): Flow<List<Category>>
}