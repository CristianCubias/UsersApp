package com.cristian.apptest.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cristian.apptest.R
import com.cristian.apptest.databinding.FragmentMainScreenBinding
import com.cristian.apptest.databinding.FragmentUserDetailBinding
import com.cristian.apptest.domain.models.UserModel
import com.cristian.apptest.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailFragment : Fragment() {
    //View binding
    private var _binding: FragmentUserDetailBinding? = null
    private val binding get() = _binding!!
    //Arguments
    private val args: UserDetailFragmentArgs by navArgs()
    //ViewModel
    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUser(args.userID).observe(viewLifecycleOwner) {user ->
            binding.txtUserLabel.text = user.name
            binding.txtDetailName.text = user.name
            binding.txtUsername.text = user.username
            binding.txtDetailEmail.text = user.email
            binding.txtStreet.text = user.address.street
            binding.txtSuite.text = user.address.suite
            binding.txtCity.text = user.address.city

            Glide.with(this)
                .load(user.imageUrl)
                .apply(RequestOptions().override(400, 400))
                .circleCrop()
                .into(binding.imageView)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}