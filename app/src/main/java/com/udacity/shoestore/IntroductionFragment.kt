package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentIntroductionBinding


class IntroductionFragment : Fragment() {
    lateinit var binding: FragmentIntroductionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIntroductionBinding.inflate(layoutInflater)
        binding.imNext.setOnClickListener {
            findNavController().navigate(R.id.action_introductionFragment_to_homeFragment)
        }
        return binding.root

    }
}