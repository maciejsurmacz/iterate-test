package com.example.iteratetest

import android.app.Application
import com.iteratehq.iterate.Iterate

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Iterate.init(this, IterateKey)
    }
}

private const val IterateKey = ""
