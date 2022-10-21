package com.example.rickandmorty2.presentation.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.rickandmorty2.R
import com.example.rickandmorty2.adapter.CharacterAdapter
import com.example.rickandmorty2.databinding.FragmentListBinding
import com.example.rickandmorty2.repository.CharacterListRepository
import com.example.rickandmorty2.presentation.viewmodel.CharacterListViewModel
import com.example.rickandmorty2.presentation.viewmodel.CharacterListViewModelFactory

class ListFragment : Fragment(R.layout.fragment_list) {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: CharacterListViewModel by activityViewModels {
        CharacterListViewModelFactory(
            CharacterListRepository()
        )
    }

    private var adapter = CharacterAdapter()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedViewModel.getCharacterList(1)
        //detailfragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            sharedViewModel.listCharacter.observe(viewLifecycleOwner) { response ->
                if (response.isSuccessful) {
                    adapter.setCharacter(response.body()!!.results)
                    txtApiError.visibility = View.GONE
                    recyclerview.visibility = View.VISIBLE
//                Log.d("result", response.body()!!.results.toString())
                } else {
                    txtApiError.text = getString(R.string.txt_error, response.code())
                    txtApiError.visibility = View.VISIBLE
                    recyclerview.visibility = View.INVISIBLE
//                Log.d("resultError", response.body().toString())
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