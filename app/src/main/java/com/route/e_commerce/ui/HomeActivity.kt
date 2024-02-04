package com.route.e_commerce.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import com.route.e_commerce.R
import com.route.e_commerce.databinding.ActivityHomeBinding
import com.route.e_commerce.ui.auth.signup.SignupFragment
//import com.route.e_commerce.ui.home.ourFragments.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
            .setupWithNavController(navController)

        // Add an OnDestinationChangedListener to the NavController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            // Check if the current destination is the signup or login fragment
            val isSignupOrLogin =
                destination.id == R.id.logInFragment || destination.id ==
                        R.id.SignupFragment || destination.id == R.id.cartFragment

            // Update the visibility of the bottom navigation bar
            updateBottomNavBarVisibility(!isSignupOrLogin)
        }
        showBottomSheet()
    }


    private fun showBottomSheet() {
        val signupFragment = SignupFragment()

        signupFragment.onSuccessSignupListener = SignupFragment.OnSuccessSignupListener {
             Snackbar.make(this,viewBinding.root, "signup successfully", Snackbar.LENGTH_LONG)
                .show()
        }
    }

    private fun updateBottomNavBarVisibility(visible: Boolean) {
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        if (visible) {
            bottomNavView.visibility = View.VISIBLE
        } else {
            bottomNavView.visibility = View.GONE
        }


    }
}