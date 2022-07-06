package com.cristian.apptest.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cristian.apptest.databinding.ItemUserBinding
import com.cristian.apptest.domain.models.ImageModel
import com.cristian.apptest.domain.models.UserModel
import javax.inject.Inject

class UserRVAdapter @Inject constructor(private val userList: List<UserModel>, private val imageList: List<ImageModel>) :
    RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
       val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context))
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.render(userList[position], imageList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}