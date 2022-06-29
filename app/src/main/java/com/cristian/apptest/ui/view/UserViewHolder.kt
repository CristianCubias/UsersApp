package com.cristian.apptest.ui.view

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cristian.apptest.data.model.ImageModel
import com.cristian.apptest.data.model.UserModel
import com.cristian.apptest.databinding.ItemUserBinding
import dagger.hilt.android.AndroidEntryPoint

class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

    private val name = binding.txtName
    private val email = binding.txtEmail
    private val image = binding.ivUser

    fun render(userModel: UserModel, imageModel: ImageModel){
        name.text = userModel.name
        email.text = userModel.email
        Glide.with(image.context)
            .load(imageModel.downloadUrl)
            .apply(RequestOptions().override(100,100))
            .centerCrop()
            .into(image)
        binding.root.setOnClickListener{
            Toast.makeText(it.context, "Clicked user: ${userModel.name}", Toast.LENGTH_SHORT).show()
        }
    }
}