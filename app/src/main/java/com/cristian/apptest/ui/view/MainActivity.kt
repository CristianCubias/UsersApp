package com.cristian.apptest.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cristian.apptest.databinding.ActivityMainBinding
import com.cristian.apptest.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //ViewBinding
    private var binding: ActivityMainBinding? = null
    //ViewModel
    private val viewModel: UserViewModel by viewModels()
    //RecyclerView Adapter
    private var _adapter: UserRVAdapter? = null
    private val adapter: UserRVAdapter get() = _adapter!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Setting ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Check if binding is not null
        _adapter = UserRVAdapter()
        binding?.let {
            setContentView(it.root)
            it.rvUsers.layoutManager = LinearLayoutManager(this)
            it.rvUsers.adapter = adapter
            it.button.setOnClickListener{
                viewModel.onCreate()
                viewModel.users.observe(this) { userList ->
                    adapter.submitList(userList)
                }
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
}