package com.android.mytasks.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.android.mytasks.R

class MainActivity : AppCompatActivity() {

    lateinit var mNavControllerMain: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mNavControllerMain =
            this@MainActivity.findNavController(R.id.navHostFragmentContainer)

        setupActionBarWithNavController(mNavControllerMain)

    }

    override fun onSupportNavigateUp(): Boolean {
        return mNavControllerMain.navigateUp() || super.onSupportNavigateUp()
    }
}