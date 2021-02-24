package com.udacity.shoestore.shoeslist

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.databinding.ShoesListFragmentBinding
import com.udacity.shoestore.models.Shoe

class ShoesListFragment : Fragment() {
    private val mainViewModel: MainViewModel by activityViewModels()
    lateinit var binding: ShoesListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoes_list_fragment,
            container,
            false
        )

        binding.createShoeButton.setOnClickListener { v ->
            v.findNavController()
                .navigate(ShoesListFragmentDirections.actionShoesListFragmentToShoeDetailFragment())
        }

        mainViewModel.shoes.observe(viewLifecycleOwner, {
            displayShoes(it)
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun displayShoes(shoes: MutableList<Shoe>) {
        shoes.forEach { s ->
            val shoeItem: ShoeItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.shoe_item, null, false)
            shoeItem.apply {
                shoeName.text = s.name
                shoeCompany.text = s.company
                shoeSize.text = s.size.toString()
                shoeDescription.text = s.description
                binding.shoesContainer.addView(this.root)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shoes_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.loginFragment -> {
                mainViewModel.logOut()
                findNavController().navigate(ShoesListFragmentDirections.actionShoesListFragmentToLoginFragment())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}