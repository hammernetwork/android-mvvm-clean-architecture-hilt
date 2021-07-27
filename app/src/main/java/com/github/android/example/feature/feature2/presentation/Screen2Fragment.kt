package com.github.android.example.feature.feature2.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.android.example.databinding.FragmentScreen2Binding
import com.github.android.shared.presentation.launchAndRepeatWithViewLifecycle
import com.github.android.shared.presentation.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class Screen2Fragment : Fragment() {

    private val viewModel: Screen2ViewModel by viewModels()
    private var binding: FragmentScreen2Binding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScreen2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        launchAndRepeatWithViewLifecycle {
            viewModel.events.collect { status ->
                binding.label.text = status.toString()
            }
        }
    }
}
