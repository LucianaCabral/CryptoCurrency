package br.leeloo.coinpaprika

import android.app.Application
import br.leeloo.coinpaprika.core.data.remote.BuildConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        BuildConfig.DEBUG
    }
}
