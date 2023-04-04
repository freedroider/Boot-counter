package com.example.bootcounter.presentation.screens.home

sealed interface HomeScreenState {
    object Undefined : HomeScreenState
    data class Loaded(val specialBody: String) : HomeScreenState
}