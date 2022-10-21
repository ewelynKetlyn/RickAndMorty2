package com.example.rickandmorty2.presentation.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.rickandmorty2.databinding.FragmentDetailBinding
import com.example.rickandmorty2.presentation.viewmodel.CharacterDetailViewModel
import com.example.rickandmorty2.presentation.viewmodel.CharacterDetailViewModelFactory
import com.example.rickandmorty2.repository.CharacterDetailRepository

class DetailFragment : Fragment() {

    private var _bindding: FragmentDetailBinding? = null
    private val binding get() = _bindding!!
    private val detailViewModel: CharacterDetailViewModel by activityViewModels {
        CharacterDetailViewModelFactory(
            CharacterDetailRepository()
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        detailViewModel.getCharacter(1)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bindding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindding = null
    }
}