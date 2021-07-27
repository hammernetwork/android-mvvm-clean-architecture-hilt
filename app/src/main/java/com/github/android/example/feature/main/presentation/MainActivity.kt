package com.github.android.example.feature.main.presentation

import com.github.android.example.base.BaseActivity
import com.github.android.example.databinding.ActivityMainBinding
import com.github.android.shared.presentation.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    override val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::inflate)
}
