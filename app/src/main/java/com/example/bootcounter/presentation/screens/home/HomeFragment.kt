package com.example.bootcounter.presentation.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.bootcounter.databinding.FragmentHomeBinding
import com.example.bootcounter.presentation.screens.ViewBindingFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : ViewBindingFragment<FragmentHomeBinding>() {
    private val viewModel by viewModels<HomeViewModel>()

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.screenState
                .collect { screenState ->
                    when (screenState) {
                        is HomeScreenState.Undefined -> {
                            binding.cpiLoading.isVisible = true
                        }
                        is HomeScreenState.Loaded -> {
                            binding.cpiLoading.isVisible = false
                            binding.tvSpecialBody.text = screenState.specialBody
                        }
                    }
                }
        }
    }
}