package com.route.data.datasourceImpl

import com.route.data.dataSourceContract.authContract.LoginDataSource
import com.route.data.dataSourceContract.categoryContract.CategoryDataSource
import com.route.data.dataSourceContract.productContract.AddProductToWishlistDataSource
import com.route.data.dataSourceContract.productContract.ProductsDatasource
import com.route.data.dataSourceContract.productContract.SpecificProductDataSource
import com.route.data.dataSourceContract.authContract.SignupDataSource
import com.route.data.dataSourceContract.cartContract.AddToCartDataSource
import com.route.data.dataSourceContract.cartContract.CartDataSource
import com.route.data.dataSourceContract.subcategoryContract.SubCategoryDataSource
import com.route.data.dataSourceContract.wishlistContract.WishlistDataSource
import com.route.data.datasourceImpl.cart.AddToCartDataSourceImpl
import com.route.data.datasourceImpl.cart.CartDataSourceImpl
import com.route.data.datasourceImpl.categoryImpl.CategoryDataSourceImpl
import com.route.data.datasourceImpl.product.AddProductToWishlistDataSourceImpl
import com.route.data.datasourceImpl.product.ProductDataSourceImpl
import com.route.data.datasourceImpl.product.SpecificProductDataSourceImpl
import com.route.data.datasourceImpl.signup.SignupDataSourceImpl
import com.route.data.datasourceImpl.subCategory.SubCategoryDataSourceImpl
import com.route.data.datasourceImpl.wishlistImpl.WishListDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class Di {

    @Provides
    fun provideCategoryDataSource(
        categoryDataSourceImpl: CategoryDataSourceImpl):CategoryDataSource{
        return categoryDataSourceImpl
    }

    @Provides
    fun provideSubCategoryDataSource(
        subCategoryDataSourceImpl: SubCategoryDataSourceImpl
    ): SubCategoryDataSource{
        return subCategoryDataSourceImpl
    }

    @Provides
    fun provideProductDataSource(
        productDataSourceImpl: ProductDataSourceImpl
    ): ProductsDatasource{
        return productDataSourceImpl
    }

    @Provides
    fun provideSignUpDataSource(
        signupDataSourceImpl: SignupDataSourceImpl
    ): SignupDataSource{
        return signupDataSourceImpl
    }
    @Provides
    fun provideSpecificProductDataSource(
        specificProductDataSourceImpl: SpecificProductDataSourceImpl
    ):SpecificProductDataSource{
        return specificProductDataSourceImpl
    }


    @Provides
    fun provideLoginDataSource(
        loginDataSourceImpl: LoginDataSourceImpl
    ): LoginDataSource {
        return loginDataSourceImpl
    }

    @Provides
    fun provideAddToWishlistDataSource(
        addProductToWishlistDataSourceImpl: AddProductToWishlistDataSourceImpl
    ): AddProductToWishlistDataSource{
        return addProductToWishlistDataSourceImpl
    }

    @Provides
    fun provideWishListDataSource(
        wishListDataSourceImpl: WishListDataSourceImpl
    ): WishlistDataSource{
        return wishListDataSourceImpl
    }

    @Provides
    fun provideAddToCartDataSource(
        addToCartDataSourceImpl: AddToCartDataSourceImpl
    ): AddToCartDataSource{
        return addToCartDataSourceImpl
    }

    @Provides
    fun provideCartDataSource(
        cartDataSourceImpl: CartDataSourceImpl
    ): CartDataSource{
        return cartDataSourceImpl
    }

}