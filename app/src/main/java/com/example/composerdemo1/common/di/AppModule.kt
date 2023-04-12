package com.example.composerdemo1.common.di

import com.example.composerdemo1.data.datasources.CartDataSource
import com.example.composerdemo1.data.datasources.CategoryDataSource
import com.example.composerdemo1.data.datasources.PaymentDataSource
import com.example.composerdemo1.data.datasources.ProductDataSource
import com.example.composerdemo1.data.datasources.impl.mock.CartMocked
import com.example.composerdemo1.data.datasources.impl.mock.CategoryMocked
import com.example.composerdemo1.data.datasources.impl.mock.PaymentMocked
import com.example.composerdemo1.data.datasources.impl.mock.ProductMocked
import com.example.composerdemo1.data.repositories.CartRepository
import com.example.composerdemo1.data.repositories.CategoryRepository
import com.example.composerdemo1.data.repositories.PaymentRepository
import com.example.composerdemo1.data.repositories.ProductRepository
import com.example.composerdemo1.domain.ports.CartRepositoryPort
import com.example.composerdemo1.domain.ports.CategoryRepositoryPort
import com.example.composerdemo1.domain.ports.PaymentRepositoryPort
import com.example.composerdemo1.domain.ports.ProductRepositoryPort
import com.example.composerdemo1.domain.usecases.cart.*
import com.example.composerdemo1.domain.usecases.payment.DoPayment
import com.example.composerdemo1.domain.usecases.payment.PaymentUseCases
import com.example.composerdemo1.domain.usecases.product.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideProductDataSource(): ProductDataSource {
        return ProductMocked()
    }

    @Provides
    @Singleton
    fun provideCategoryDataSource(): CategoryDataSource {
        return CategoryMocked()
    }

    @Provides
    @Singleton
    fun provideCartProductDataSource(): CartDataSource {
        return CartMocked()
    }

    @Provides
    @Singleton
    fun providePaymentDataSource(): PaymentDataSource {
        return PaymentMocked()
    }

    @Provides
    @Singleton
    fun provideProductRepository(
        productDataSource: ProductDataSource,
    ): ProductRepositoryPort {
        return ProductRepository(productDataSource)
    }

    @Provides
    @Singleton
    fun provideCategoryRepository(
        categoryDataSource: CategoryDataSource,
    ): CategoryRepositoryPort {
        return CategoryRepository(categoryDataSource)
    }

    @Provides
    @Singleton
    fun provideCartRepository(
        cartDataSource: CartDataSource,
    ): CartRepositoryPort {
        return CartRepository(cartDataSource)
    }

    @Provides
    @Singleton
    fun providePaymentRepository(
        paymentDataSource: PaymentDataSource,
    ): PaymentRepositoryPort {
        return PaymentRepository(paymentDataSource)
    }

    @Provides
    @Singleton
    fun provideProductUseCases(
        productRepository: ProductRepositoryPort,
        categoryRepository: CategoryRepositoryPort,
    ): ProductUseCases {
        return ProductUseCases(
            getProducts = GetProductList(productRepository),
            getProduct = GetProductDetail(productRepository),
            getCategories = GetCategoryList(categoryRepository)
        )
    }

    @Provides
    @Singleton
    fun provideCartUseCases(
        cartRepository: CartRepositoryPort,
    ): CartUseCases {
        return CartUseCases(
            saveItemCart = SaveItemCart(cartRepository),
            removeItemCart = RemoveItemCart(cartRepository),
            getCartItems = GetCartItems(cartRepository),
            updateCartItems = UpdateCartItems(cartRepository)
        )
    }

    @Provides
    @Singleton
    fun providePaymentUseCases(
        paymentRepository: PaymentRepositoryPort,
    ): PaymentUseCases {
        return PaymentUseCases(
            doPayment = DoPayment(paymentRepository)
        )
    }
}