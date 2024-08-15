package com.example.cryptoapp2024.presentation

import android.content.Context
import android.util.Log
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.example.cryptoapp2024.data.worker.ChildWorkerFactory
import com.example.cryptoapp2024.data.worker.RefreshDataWorker
import javax.inject.Inject
import javax.inject.Provider

class WorkerFactory @Inject constructor(
    private val map: @JvmSuppressWildcards Map<Class<out ListenableWorker>, Provider<ChildWorkerFactory>>
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when (workerClassName) {

            RefreshDataWorker::class.qualifiedName -> {
                map[RefreshDataWorker::class.java]?.get()?.create(appContext, workerParameters)
            }

            else -> null
        }
    }
}