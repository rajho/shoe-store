package com.udacity.shoestore.instructions

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionsFragmentBinding

class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<InstructionsFragmentBinding>(inflater, R.layout.instructions_fragment, container, false)

        binding.goStoreButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_instructionsFragment_to_shoesListFragment))
        return binding.root
    }


}