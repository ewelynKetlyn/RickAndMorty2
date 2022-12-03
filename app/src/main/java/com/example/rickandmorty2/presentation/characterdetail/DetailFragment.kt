package com.example.rickandmorty2.presentation.characterdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rickandmorty2.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private var _bindding: FragmentDetailBinding? = null
    private val binding get() = _bindding!!
    private val detailViewModel: CharacterDetailViewModel by viewModel()

    private var characterId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            characterId = it.getInt("characterId")
        }
        getCharacterDetail()
    }

    fun getCharacterDetail() {
        characterId?.let {
            detailViewModel.getCharacter(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailViewModel.character.observe(viewLifecycleOwner) { character ->
            character?.let {
                binding.txtName.text = character.name
                Picasso.get().load(it.image).into(binding.imgCharacter)
                binding.txtStatus.text = character.status
                binding.txtIdCharacter.text = character.id.toString()
                binding.txtSpecie.text = character.species
                binding.txtGender.text = character.gender
                binding.txtNEpisodes.text = character.episode.size.toString()
                binding.txtOrigin.text = character.origin.name
                binding.txtLocation.text = character.location.name
            }
        }
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