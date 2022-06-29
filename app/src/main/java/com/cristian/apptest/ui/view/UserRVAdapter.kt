package com.cristian.apptest.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cristian.apptest.data.model.ImageModel
import com.cristian.apptest.data.model.UserModel
import com.cristian.apptest.databinding.ItemUserBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class UserRVAdapter @Inject constructor(private val userList: List<UserModel>, private val imageList: List<ImageModel>) :
    RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
       val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context))
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        val image = imageList[position]
        holder.render(user, image)
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}