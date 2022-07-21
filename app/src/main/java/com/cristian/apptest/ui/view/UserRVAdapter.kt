package com.cristian.apptest.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.cristian.apptest.R
import com.cristian.apptest.databinding.ItemUserBinding
import com.cristian.apptest.domain.models.UserModel


class UserRVAdapter (private val clickListener: (userID : Int) -> Unit): ListAdapter<UserModel, UserViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
       val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context))
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.itemView.setOnClickListener{ clickListener(user.id) }
        holder.bind(user)
    }
}

class DiffCallback : DiffUtil.ItemCallback<UserModel>() {
    override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
        return oldItem == newItem
    }
}