package com.github.android.example.feature.main.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.github.android.example.databinding.FragmentMainBinding
import com.github.android.example.feature.main.presentation.MainFragmentDirections
import com.github.android.shared.presentation.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

//    @Inject
//    lateinit var router: MainRouter

    private var binding: FragmentMainBinding by viewBinding()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        binding.screen1Btn.setOnClickListener {
            openScreen1()
        }
        binding.screen2Btn.setOnClickListener {
            openScreen2()
        }
    }

    private fun openScreen1() {
        val action = MainFragmentDirections.openScreen1()
        findNavController().navigate(action)

        // router.openScreen1()
    }

    private fun openScreen2() {
        val action = MainFragmentDirections.openScreen2()
        findNavController().navigate(action)

        // router.openScreen2()
    }
}
