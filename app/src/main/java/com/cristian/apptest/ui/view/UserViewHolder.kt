package com.cristian.apptest.ui.view

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cristian.apptest.databinding.ItemUserBinding

class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

    private val name = binding.txtName
    private val email = binding.txtEmail
    private val image = binding.ivUser

    fun render(){
        Glide.with(image.context)
            .load("")
            .apply(RequestOptions().override(100,100))
            .centerCrop()
            .into(image)
        binding.root.setOnClickListener{
           // Toast.makeText(it.context, "Clicked user: ${userModel.name}", Toast.LENGTH_SHORT).show()
        }
    }
}