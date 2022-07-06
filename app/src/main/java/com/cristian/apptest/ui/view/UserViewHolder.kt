package com.cristian.apptest.ui.view

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cristian.apptest.databinding.ItemUserBinding
import com.cristian.apptest.domain.models.ImageModel
import com.cristian.apptest.domain.models.UserModel

class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

    private val nameTxtVw = binding.txtName
    private val emailTxtVw = binding.txtEmail
    private val imageVw = binding.ivUser

    fun render(user: UserModel, image: ImageModel){
        nameTxtVw.text = user.name
        emailTxtVw.text = user.email
        Glide.with(imageVw.context)
            .load(image.url)
            .apply(RequestOptions().override(100,100))
            .centerCrop()
            .into(imageVw)
        binding.root.setOnClickListener{
           Toast.makeText(it.context, "Clicked user: ${user.name}", Toast.LENGTH_SHORT).show()
        }
    }
}