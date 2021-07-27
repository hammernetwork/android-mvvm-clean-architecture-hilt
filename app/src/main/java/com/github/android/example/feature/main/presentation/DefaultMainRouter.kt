package com.github.android.example.feature.main.presentation

import android.app.Activity
import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.github.android.example.R
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

// Use this to navigate from other features. If it needs.
class DefaultMainRouter @Inject constructor(
    @ActivityContext context: Context,
) : MainRouter {

    private val navController: NavController by lazy {
        (context as Activity).findNavController(R.id.main_nav_host)
    }

    override fun openScreen1() {
        val action = MainFragmentDirections.openScreen1()
        navController.navigate(action)
    }

    override fun openScreen2() {
        val action = MainFragmentDirections.openScreen2()
        navController.navigate(action)
    }
}