package com.route.e_commerce.ui.tabs.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.route.e_commerce.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    lateinit var viewBinding:FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding= FragmentProfileBinding.inflate(inflater,container,false)
        return viewBinding.root
    }


}