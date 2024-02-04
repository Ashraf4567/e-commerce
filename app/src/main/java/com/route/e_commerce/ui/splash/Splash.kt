package com.route.e_commerce.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.route.e_commerce.databinding.ActivitySplashBinding
import com.route.e_commerce.ui.HomeActivity


class Splash : AppCompatActivity() {
  private  lateinit var viewBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        initViews()
        splashEffect()

    }

    private fun splashEffect() {
        Handler(Looper.getMainLooper())
            .postDelayed(Runnable {
                                  navigateToHome()
                finish()
            },2000)
    }

    private fun initViews() {
        viewBinding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
    private fun navigateToHome() {
        val intent= Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }


}