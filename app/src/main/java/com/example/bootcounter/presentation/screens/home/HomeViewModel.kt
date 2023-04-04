package com.example.bootcounter.presentation.screens.home

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bootcounter.R
import com.example.bootcounter.domain.entity.BootEvent
import com.example.bootcounter.domain.repository.BootRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val application: Application,
    bootRepository: BootRepository
) : ViewModel() {
    private val _screenState = bootRepository.subscribe()
        .map { events -> HomeScreenState.Loaded(specialBody = specialBody(events)) }
    val screenState = _screenState.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = HomeScreenState.Undefined
    )

    private fun specialBody(events: List<BootEvent>): String {
        return if (events.isEmpty()) {
            application.getString(R.string.no_boots_detected)
        } else {
            events.asSequence()
                .withIndex()
                .joinToString(separator = "\n") { "${it.index + 1} - ${it.value.timestamp}" }
        }
    }
}