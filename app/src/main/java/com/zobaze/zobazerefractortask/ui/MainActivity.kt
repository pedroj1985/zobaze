package com.zobaze.zobazerefractortask.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.zobaze.zobazerefractortask.databinding.MainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        MainBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModels<MainViewModel> ()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setupRecyclerView()

        viewModel.getEmployees()
        viewModel.errorMessage.observe(this){
            Toast.makeText(this, "it", Toast.LENGTH_LONG).show()
        }

    }

    private fun setupRecyclerView(){
        val adapter = EmployeeAdapter()
        binding.rvEmployee.adapter = adapter
    }

}

