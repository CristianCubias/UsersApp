package com.cristian.apptest.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cristian.apptest.databinding.FragmentMainScreenBinding
import com.cristian.apptest.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainScreenFragment : Fragment() {

    //ViewBinding
    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!
    //ViewModel
    private val viewModel: UserViewModel by viewModels()
    //RecyclerView Adapter
    private var _adapter: UserRVAdapter? = null
    private val adapter: UserRVAdapter get() = _adapter!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _adapter = UserRVAdapter(this::onClickListener)
        binding.rvUsers.adapter = adapter
        binding.rvUsers.layoutManager = LinearLayoutManager(context)
        viewModel.getUsers().observe(viewLifecycleOwner) { userList ->
            adapter.submitList(userList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _adapter = null
        _binding = null
    }

    private fun onClickListener(userID: Int) {
        val action = MainScreenFragmentDirections.actionMainScreenFragmentToUserDetailFragment(userID)
        binding.root.findNavController().navigate(action)
    }
}