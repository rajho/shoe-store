package com.udacity.shoestore.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseMethod
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding


class ShoeDetailFragment : Fragment() {
    private val mainViewModel: MainViewModel by activityViewModels()
    lateinit var navController: NavController
    lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )

        navController = findNavController()
        binding.cancelButton.setOnClickListener {
            navController.navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoesListFragment())
        }
        binding.saveButton.setOnClickListener {
            saveShoe()
        }


        return binding.root
    }

    private fun saveShoe() {
        mainViewModel.saveShoe()
        navController.navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoesListFragment())

    }
}