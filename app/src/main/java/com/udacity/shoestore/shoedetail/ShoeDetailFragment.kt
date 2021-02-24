package com.udacity.shoestore.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment : Fragment() {
    private val mainViewModel: MainViewModel by activityViewModels()
    lateinit var navController: NavController
    lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(
            inflater, R.layout
                .fragment_shoe_detail, container, false
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

    fun saveShoe() {
        val shoe = Shoe(
            binding.shoeNameText.text?.toString() ?: "",
            binding.shoeSizeText.text?.toString()?.toDoubleOrNull() ?: 0.0,
            binding.shoeCompanyText.text?.toString() ?: "",
            binding.shoeDescriptionText.text?.toString() ?: "")
        mainViewModel.saveShoe(shoe)
        navController.navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoesListFragment())
    }

}