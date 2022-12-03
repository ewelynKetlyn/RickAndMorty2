package com.example.rickandmorty2.presentation.characterlist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.rickandmorty2.R
import com.example.rickandmorty2.databinding.FragmentListBinding
import com.example.rickandmorty2.presentation.characterlist.adapter.CharacterAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment(R.layout.fragment_list) {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CharacterListViewModel by viewModel()

    private var adapter = CharacterAdapter()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel.getCharacterList(1)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewModel.listCharacter.observe(viewLifecycleOwner) { characterList ->
                if (characterList.results.isNotEmpty()) {
                    adapter.setCharacter(characterList.results)
                    txtApiError.visibility = View.GONE
                    recyclerview.visibility = View.VISIBLE
                } else {
                    txtApiError.text = "Ocorreu um erro"
                    txtApiError.visibility = View.VISIBLE
                    recyclerview.visibility = View.INVISIBLE
                }
            }


            recyclerview.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            recyclerview.adapter = adapter

            btnFilter.setOnClickListener {
                findNavController().navigate(R.id.action_listFragment_to_filterFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}