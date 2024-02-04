package com.route.e_commerce.ui.auth.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.route.e_commerce.R
import com.route.e_commerce.databinding.FragmentLogInBinding
import com.route.e_commerce.util.ControlState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogInFragment : Fragment() {

    lateinit var binding: FragmentLogInBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLogInBinding.inflate(inflater ,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.createAccount.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_SignupFragment)

        }
        binding.vm = viewModel

        viewModel.state.observe(viewLifecycleOwner){
            when(it){
                ControlState.LOADING -> handleLoading()
                ControlState.ERROR -> handleError()
                ControlState.SUCCESS -> handleSuccess()
            }
        }

    }

    private fun handleError() {
        binding.progressBar.isVisible = false
        Toast.makeText(activity , "something went wrong" , Toast.LENGTH_LONG).show()
        binding.logInBtn.isEnabled = true
    }

    private fun handleLoading() {
        binding.progressBar.isVisible = true
        binding.logInBtn.isEnabled = false
    }

    private fun handleSuccess() {
        binding.progressBar.isVisible = false
        findNavController().navigate(R.id.action_logInFragment_to_homeFragment)
    }

}