package com.example.composerdemo1.ui.features.productlist

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composerdemo1.common.previews.PreviewData
import com.example.composerdemo1.domain.models.Category
import com.example.composerdemo1.domain.models.Product
import com.example.composerdemo1.ui.features.productlist.components.lists.ProductItemList
import com.example.composerdemo1.ui.theme.lightGrayBackground

@Composable
fun ProductListScreen(
    category: Category,
    productSelected: (Product) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ProductListViewModel = hiltViewModel()
) {
    val products by viewModel.productListState(category).collectAsState()

    ProductListContent(
        products,
        productSelected,
        modifier = modifier.background(lightGrayBackground)
    )
}

@Composable
fun ProductListContent(
    products: List<Product>,
    productSelected: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    ProductItemList(
        products = products,
        productSelected = productSelected,
        modifier = modifier
    )
}

@Preview
@Composable
fun ProductListScreenPreview() {
    ProductListContent(
        products = PreviewData.products(),
        productSelected = {}
    )
}