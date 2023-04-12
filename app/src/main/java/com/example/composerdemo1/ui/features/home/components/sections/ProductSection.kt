package com.example.composerdemo1.ui.features.home.components.sections

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composerdemo1.common.previews.PreviewData
import com.example.composerdemo1.domain.models.Product
import com.example.composerdemo1.ui.composables.cards.ProductCard

@Composable
fun ProductSection(
    products: List<Product>,
    productSelected: (product: Product) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(products, key = { it.id }) { product ->
            ProductCard(product, productSelected)
        }
    }
}

@Preview
@Composable
fun PreviewProductSection() {
    ProductSection(
        products = PreviewData.products(),
        productSelected = {}
    )
}