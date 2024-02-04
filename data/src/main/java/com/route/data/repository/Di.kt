package com.route.data.repository

import com.route.data.repository.authRepo.LoginRepositoryImpl
import com.route.data.repository.categories.CategoriesRepositoryImpl
import com.route.data.repository.product.AddProductToWishlistRepoImpl
import com.route.data.repository.product.ProductRepositoryImpl
import com.route.data.repository.product.SpecificProductRepositoryImpl
import com.route.data.repository.authRepo.SignupRepositoryImpl
import com.route.data.repository.cart.AddToCartRepositoryImpl
import com.route.data.repository.cart.CartRepositoryImpl
import com.route.data.repository.cart.RemoveCartItemRepositoryImpl
import com.route.data.repository.subCategory.SubCategoriesRepositoryImpl
import com.route.data.repository.wishlist.WishlistRepoImpl
import com.route.domain.repository.AddToCartRepository
import com.route.domain.repository.AddToWishlistRepository
import com.route.domain.repository.CartRepository
import com.route.domain.repository.CategoriesRepository
import com.route.domain.repository.LoginRepository
import com.route.domain.repository.ProductsRepository
import com.route.domain.repository.RemoveCartItemRepository
import com.route.domain.repository.SignupRepository
import com.route.domain.repository.SpecificProductRepository
import com.route.domain.repository.SubCategoriesRepository
import com.route.domain.repository.WishListRepository
import com.route.domain.sessionManager.SessionManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class Di{

   @Binds
   abstract fun bindCategoriesRepository(repo: CategoriesRepositoryImpl):CategoriesRepository

   @Binds
   abstract fun bindSubCategoriesRepo(repo: SubCategoriesRepositoryImpl): SubCategoriesRepository

   @Binds
   abstract fun bindProductsRepo(repo: ProductRepositoryImpl): ProductsRepository

   @Binds
   abstract fun bindSpecificProductsRepo(repo: SpecificProductRepositoryImpl): SpecificProductRepository

   @Binds
   abstract fun bindSignupRepo(repo: SignupRepositoryImpl): SignupRepository

   @Binds
   abstract fun bindLoginRepo(repo: LoginRepositoryImpl): LoginRepository

   @Binds
   abstract fun bindSessionManager(manager: SessionManagerImpl): SessionManager

   @Binds
   abstract fun bindAddToWishlist(repo: AddProductToWishlistRepoImpl): AddToWishlistRepository

   @Binds
   abstract fun bindWishlist(repo: WishlistRepoImpl): WishListRepository

   @Binds
   abstract fun bindAddToCart(repo: AddToCartRepositoryImpl): AddToCartRepository

   @Binds
   abstract fun bindCart(repo: CartRepositoryImpl): CartRepository

   @Binds
   abstract fun bindRemoveCartItem(repo: RemoveCartItemRepositoryImpl): RemoveCartItemRepository

}