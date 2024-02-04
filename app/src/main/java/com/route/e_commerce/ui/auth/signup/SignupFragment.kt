package com.route.e_commerce.ui.auth.signup

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
import com.route.e_commerce.databinding.FragmentSignupBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignupFragment : Fragment() {

    lateinit var binding: FragmentSignupBinding
    lateinit var viewModel: SignupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[SignupViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignupBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        initObservers()

        binding.signupBtn.setOnClickListener {
            viewModel.signupUser()

        }
    }

    private fun initObservers() {
        viewModel.stateLiveData.observe(viewLifecycleOwner , ::handleState)
    }

    private fun handleState(state: SignupState?) {
        when(state){
            SignupState.LOADING -> handleLoading()
            SignupState.ERROR -> handleError()
            SignupState.SUCCESS -> handleSuccess()
            null -> TODO()
        }
    }

    private fun handleError() {
        binding.progressBar.isVisible = false
        binding.signupBtn.isEnabled = true
        Toast.makeText(activity , "something went wrong" , Toast.LENGTH_SHORT).show()

    }

    private fun handleSuccess() {
        binding.progressBar.isVisible = false

        onSuccessSignupListener?.onSuccess()

        findNavController().navigate(R.id.action_SignupFragment_to_homeFragment)
    }

    var onSuccessSignupListener: OnSuccessSignupListener? = null
    fun interface OnSuccessSignupListener{
        fun onSuccess()
    }

    private fun handleLoading() {
        binding.progressBar.isVisible = true
        binding.signupBtn.isEnabled = false
    }

}