package com.vginert.rohlik

import android.app.Application
import com.vginert.rohlik.cart.di.cartModule
import com.vginert.rohlik.catalog.di.catalogModule
import com.vginert.rohlik.main.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

class RohlikApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupDependencyInjection()
    }

    private fun setupDependencyInjection(): KoinApplication =
        startKoin {
            androidContext(this@RohlikApplication)
            modules(
                networkModule,
                catalogModule,
                cartModule,
            )
        }

}
