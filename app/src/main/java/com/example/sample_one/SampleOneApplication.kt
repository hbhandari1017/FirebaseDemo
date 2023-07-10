package com.example.sample_one

import android.app.Application
import com.google.firebase.FirebaseApp

class SampleOneApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}