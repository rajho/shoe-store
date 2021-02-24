package com.udacity.shoestore.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels()

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<LoginFragmentBinding>(
            inflater,
            R.layout.login_fragment,
            container,
            false
        )

        mainViewModel.isLoggedIn.value?.let {
            if (it) {
                findNavController()
                    .navigate(LoginFragmentDirections.actionLoginFragmentToShoesListFragment())
            }
        }

        mainViewModel.isLoggedIn.observe(viewLifecycleOwner, { isLoggedIn ->
            if (isLoggedIn) {
                findNavController()
                    .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
        })

        val onClickListener = View.OnClickListener {
            mainViewModel.logIn()
        }
        binding.signInButton.setOnClickListener(onClickListener)
        binding.signUpButton.setOnClickListener(onClickListener)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel
    }

}