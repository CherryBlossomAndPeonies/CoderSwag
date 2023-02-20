package com.example.coderswag.controller

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.example.coderswag.R
import com.example.coderswag.adapters.CategoryAdapter
import com.example.coderswag.model.Category
import com.example.coderswag.services.DataService
import com.example.coderswag.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var adapter: CategoryAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        adapter = CategoryAdapter(this, DataService.catagories)

        binding.categoriesListViewId.adapter = adapter
    }
}