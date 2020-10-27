package com.android.mytasks.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.android.mytasks.R

class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    lateinit var mNavControllerMain: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mNavControllerMain =
            this@MainActivity.findNavController(R.id.navHostFragmentContainer)
        mNavControllerMain.addOnDestinationChangedListener(this@MainActivity)

        setupActionBarWithNavController(navController = mNavControllerMain, AppBarConfiguration(
            topLevelDestinationIds = setOf(
               R.id.homeFragment
            )
        ))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}