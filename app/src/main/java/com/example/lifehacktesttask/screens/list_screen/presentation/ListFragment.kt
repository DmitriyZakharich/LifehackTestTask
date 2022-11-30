package com.example.lifehacktesttask.screens.list_screen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lifehacktesttask.MyApp
import com.example.lifehacktesttask.databinding.FragmentListBinding
import com.example.lifehacktesttask.screens.list_screen.viewmodel.ListViewModelFactory
import com.example.lifehacktesttask.screens.list_screen.presentation.interfaces.ListViewModel
import com.example.lifehacktesttask.screens.list_screen.viewmodel.ListViewModelImpl


import javax.inject.Inject

class ListFragment : Fragment() {

    @Inject
    lateinit var vmFactory: ListViewModelFactory
    private lateinit var viewModel: ListViewModel

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireContext().applicationContext as MyApp).listScreenComponent.inject(this)
        viewModel = ViewModelProvider(this, vmFactory)[ListViewModelImpl::class.java]
        viewModel.adapter.observe(viewLifecycleOwner) {
            binding.recyclerView.adapter = it
        }

        viewModel.getAdapter()
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}