package com.cristian.apptest.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cristian.apptest.databinding.ItemUserBinding
import javax.inject.Inject

class UserRVAdapter :
    RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
       val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context))
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 0
    }
}