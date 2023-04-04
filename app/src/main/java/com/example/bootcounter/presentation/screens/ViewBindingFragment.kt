package com.example.bootcounter.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class ViewBindingFragment<VB : ViewBinding> : Fragment() {
    private var _binding: VB? = null
    val binding
        get() = _binding ?: error("This property is only valid between onCreateView and onDestroyView ")

    abstract fun createBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): VB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return createBinding(inflater, container, savedInstanceState)
            .also { _binding = it }
            .root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}