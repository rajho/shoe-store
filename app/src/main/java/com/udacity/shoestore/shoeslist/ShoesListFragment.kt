package com.udacity.shoestore.shoeslist

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.MainViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoesListFragmentBinding
import com.udacity.shoestore.login.LoginFragment
import com.udacity.shoestore.login.LoginFragmentDirections

class ShoesListFragment : Fragment() {
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<ShoesListFragmentBinding>(
            inflater,
            R.layout.shoes_list_fragment,
            container,
            false
        )



        setHasOptionsMenu(true)
        return binding.root
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