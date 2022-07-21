package com.cristian.apptest.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.cristian.apptest.R
import com.cristian.apptest.databinding.ActivityMainBinding
import com.cristian.apptest.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //View Binding
    private lateinit var binding: ActivityMainBinding
    //View Model
    private val viewModel: UserViewModel by viewModels()
    //Navigation
    private var _navController: NavController? = null
    private val navController: NavController get() = _navController!!
    //Fragment
    private var _navHostFragment: NavHostFragment? = null
    private val navHostFragment: NavHostFragment get() = _navHostFragment!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        _navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        _navController = navHostFragment.navController
    }
}