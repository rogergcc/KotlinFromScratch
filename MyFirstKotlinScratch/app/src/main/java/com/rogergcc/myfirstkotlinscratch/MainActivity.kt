package com.rogergcc.myfirstkotlinscratch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val myVarInmutable : Double=24.4

        var myVarMutable : Double=24.4

        myVarMutable= 22.4

        var great = "Hello, World"

        var greatCatch :String?=null

        greatCatch= "Hey, whats up, everybody?"



    }
}