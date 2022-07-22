package com.activity.viewmodelwithcoroutinescope

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    //get viewModel instance using viewProvider
    private lateinit var  mainActivityViewModel : MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        //get userData function
        mainActivityViewModel.getUserData()
        //observe user live data in mainActivityViewModel
        mainActivityViewModel.users.observe(this, Observer { myUsers ->
            myUsers.forEach{
                Log.i("tag","name is ${it.name}")
            }

        })
    }
}