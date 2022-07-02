package com.cristian.apptest.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cristian.apptest.databinding.ActivityMainBinding
import com.cristian.apptest.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //ViewBinding
    private var binding: ActivityMainBinding? = null
    //ViewModel
    private val viewModel: UserViewModel by viewModels()
    //RecyclerView Adapter
    @Inject
    lateinit var adapter: UserRVAdapter

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
    }

    private fun initRV() {
        //Setting RecyclerView
        binding?.let {
            it.rvUsers.layoutManager = LinearLayoutManager(this)
            adapter = UserRVAdapter()
            it.rvUsers.adapter = adapter
        }
   }
}