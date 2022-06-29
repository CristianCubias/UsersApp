package com.cristian.apptest.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cristian.apptest.data.model.ImageModel
import com.cristian.apptest.data.model.UserModel
import com.cristian.apptest.databinding.ActivityMainBinding
import com.cristian.apptest.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //ViewBinding
    private var binding: ActivityMainBinding? = null
    //ViewModel
    private val viewModel: UserViewModel by viewModels()
    //RecyclerView Adapter
    @Inject //Is this correct?
    private lateinit var adapter: UserRVAdapter

    //Data Lists. ESTO SE BORRARÁ PORQUE RECIBIRÁ LOS DATOS DESDE EL DOMINIO
    private var userList = emptyList<UserModel>()
    private var imageList = emptyList<ImageModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Setting ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Check if binding is not null
        binding?.let {
            setContentView(it.root)
            it.button.setOnClickListener{
                //loadList()
                //TODO: Deshabilitado por ahora
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //Setting ViewBinding and RecyclerView adapter to null
        binding?.let {
            it.rvUsers.adapter = null
            binding = null
        }
    }

    private fun loadList() {
        //Loading data
        viewModel.onCreate()
        viewModel.userModel.observe(this) {users ->
            binding?.let {
                it.txtView.text = "Check logcat"
                userList = users
            }
        }
        viewModel.imagesModel.observe(this) {images ->
            imageList = images
            initRV(userList, imageList)
        }
    }

    private fun initRV(userList: List<UserModel>, imageList: List<ImageModel>) {
        //Setting RecyclerView
        binding?.let {
            it.rvUsers.layoutManager = LinearLayoutManager(this)
            adapter = UserRVAdapter(userList, imageList)
            it.rvUsers.adapter = adapter
        }
   }
}