package com.example.bootcounter.presentation.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.util.Log
import com.example.bootcounter.domain.entity.BootEvent
import com.example.bootcounter.domain.repository.BootRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class BootReceiver : BroadcastReceiver() {
    @Inject
    lateinit var bootRepository: BootRepository

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BOOT_COMPLETED)
            CoroutineScope(SupervisorJob() + Dispatchers.IO).launch {
                val timestamp = System.currentTimeMillis() - SystemClock.elapsedRealtime()
                try {
                    bootRepository.save(BootEvent(timestamp))
                } catch (throwable: Throwable) {
                    throwable.printStackTrace()
                } finally {
                    Log.e("onReceive", "Done")
                }
            }
    }
}