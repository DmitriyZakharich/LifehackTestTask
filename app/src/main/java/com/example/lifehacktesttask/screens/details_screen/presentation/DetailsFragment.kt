package com.example.lifehacktesttask.screens.details_screen.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lifehacktesttask.MyApp
import com.example.lifehacktesttask.databinding.FragmentDetailsBinding
import com.example.lifehacktesttask.screens.details_screen.domain.model.CompanyInfoDomain
import com.example.lifehacktesttask.screens.details_screen.presentation.interfaces.DetailsViewModel
import com.example.lifehacktesttask.screens.details_screen.viewmodel.DetailsViewModelFactory
import com.example.lifehacktesttask.screens.details_screen.viewmodel.DetailsViewModelImpl
import com.squareup.picasso.Picasso
import javax.inject.Inject

class DetailsFragment : Fragment() {

    @Inject
    lateinit var vmFactory: DetailsViewModelFactory
    private lateinit var viewModel: DetailsViewModel

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val picasso = Picasso.get()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireContext().applicationContext as MyApp).detailsScreenComponent.inject(this)
        viewModel = ViewModelProvider(this, vmFactory)[DetailsViewModelImpl::class.java]
        viewModel.info.observe(viewLifecycleOwner, observer())

        val id = arguments?.getString("id")
        Log.d("1223231", "id: $id")
        if (id != null) viewModel.getData(id)
    }

    private fun observer() = Observer<CompanyInfoDomain> {
        binding.progressBar.visibility = View.GONE

        binding.companyId.text = it.id
        binding.description.text = it.description
        binding.lat.text = it.lat.toString()
        binding.lon.text = it.lon.toString()
        binding.name.text = it.name
        binding.phone.text = it.phone
        binding.www.text = it.www

        it.img.into(binding.imageView2)

        binding.companyId.visibility = View.VISIBLE
        binding.description.visibility = View.VISIBLE
        binding.lat.visibility = View.VISIBLE
        binding.lon.visibility = View.VISIBLE
        binding.name.visibility = View.VISIBLE
        binding.phone.visibility = View.VISIBLE
        binding.www.visibility = View.VISIBLE
        binding.imageView2.visibility = View.VISIBLE
        binding.phoneImg.visibility = View.VISIBLE
        binding.globeImg.visibility = View.VISIBLE
        binding.coordinatesImg.visibility = View.VISIBLE
    }

    companion object {
        @JvmStatic
        fun newInstance() = DetailsFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}