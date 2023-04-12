package com.example.composerdemo1.ui.patterns

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.composerdemo1.common.navigation.NavigationBarSection
import com.example.composerdemo1.common.navigation.OrderNowScreenRoute
import com.example.composerdemo1.common.navigation.navigateSaved
import com.example.composerdemo1.domain.models.Category
import com.example.composerdemo1.domain.models.Product
import com.example.composerdemo1.domain.models.order.Order
import com.example.composerdemo1.domain.models.order.SummaryTotals
import com.example.composerdemo1.main.OrderNowState
import com.example.composerdemo1.ui.features.cart.CartScreen
import com.example.composerdemo1.ui.features.checkout.CheckoutScreen
import com.example.composerdemo1.ui.features.home.HomeScreen
import com.example.composerdemo1.ui.features.placeorder.PlaceOrderScreen
import com.example.composerdemo1.ui.features.productdetail.ProductDetailScreen
import com.example.composerdemo1.ui.features.productlist.ProductListScreen

@Composable
fun OrderNowNavHost(
    appState: OrderNowState,
    paddingValues: PaddingValues,
) {
    NavHost(
        navController = appState.navController,
        startDestination = NavigationBarSection.Home.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        appSoGraph(appState)
    }
}

fun NavGraphBuilder.appSoGraph(appState: OrderNowState) {

    val homeRoute = OrderNowScreenRoute.Home.route
    val listRoute = OrderNowScreenRoute.ProductList.route
    val detailRoute = OrderNowScreenRoute.ProductDetail.route
    val cartRoute = OrderNowScreenRoute.Cart.route
    val checkout = OrderNowScreenRoute.Checkout.route
    val placeOrder = OrderNowScreenRoute.PlaceOrder.route

    val productSelectedInHome: (Product) -> Unit = { product: Product ->
        appState.productSelected = product
        appState.navigateSaved(detailRoute, homeRoute)
    }
    val categorySelectedInHome: (Category) -> Unit = { category: Category ->
        appState.categorySelected = category
        appState.navigateSaved(listRoute, homeRoute)
    }
    val productSelectedInList: (Product) -> Unit = { product: Product ->
        appState.productSelected = product
        appState.navigateSaved(detailRoute, listRoute)
    }

    val goToCartScreen: () -> Unit = {
        appState.navigateSaved(cartRoute, detailRoute)
    }

    val goToCheckoutScreen: (SummaryTotals) -> Unit = { summary ->
        appState.summaryTotals = summary
        appState.navigateSaved(checkout, cartRoute)
    }

    val goToPlaceOrderScreen: (Order) -> Unit = { order ->
        appState.orderSelected = order
        appState.navigateSaved(placeOrder, checkout)
    }

    // Home Screen Graph
    composable(NavigationBarSection.Home.route) {
        HomeScreen(
            categorySelected = categorySelectedInHome,
            productSelected = productSelectedInHome
        )
    }

    // Cart Screen Graph
    composable(NavigationBarSection.Cart.route) {
        CartScreen(
            goToCheckout = goToCheckoutScreen
        )
    }

    // Product List Screen Graph
    composable(OrderNowScreenRoute.ProductList.route) {
        ProductListScreen(
            category = appState.categorySelected,
            productSelected = productSelectedInList
        )
    }

    // Product Detail Screen Graph
    composable(OrderNowScreenRoute.ProductDetail.route) {
        ProductDetailScreen(
            product = appState.productSelected,
            goToCart = goToCartScreen
        )
    }

    // Checkout Screen Graph
    composable(OrderNowScreenRoute.Checkout.route) {
        CheckoutScreen(
            summary = appState.summaryTotals,
            goToPlaceOrder = goToPlaceOrderScreen
        )
    }

    // Process Order Screen Graph
    composable(OrderNowScreenRoute.PlaceOrder.route) {
        PlaceOrderScreen(
            order = appState.orderSelected
        )
    }
}