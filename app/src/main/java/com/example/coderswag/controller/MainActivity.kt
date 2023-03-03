package com.example.coderswag.controller

import android.content.Intent
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coderswag.R
import com.example.coderswag.adapters.CategoryAdapter
import com.example.coderswag.adapters.CategoryRecyclerAdapter
import com.example.coderswag.model.Category
import com.example.coderswag.services.DataService
import com.example.coderswag.databinding.ActivityMainBinding
import com.example.coderswag.utilities.EXTRA_CATEGORY

class MainActivity : AppCompatActivity() {
    //lateinit var adapter: CategoryAdapter
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: CategoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //adapter = CategoryAdapter(this, DataService.catagories)
        adapter = CategoryRecyclerAdapter(this, DataService.catagories,
            {
                category ->
                    var intent = Intent(this, ProductsActivity :: class.java)
                    intent.putExtra(EXTRA_CATEGORY, category.title)
                    startActivity(intent)
            })

        binding.categoryRecyclerViewId.adapter = adapter

        var linearManager = LinearLayoutManager(this)
        binding.categoryRecyclerViewId.layoutManager = linearManager
        binding.categoryRecyclerViewId.setHasFixedSize(true)
    }
}