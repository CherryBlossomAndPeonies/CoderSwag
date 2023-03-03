package com.example.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.R
import com.example.coderswag.model.Category

class CategoryRecyclerAdapter(val context: Context, val catergories: List<Category>, val itemClick:(Category) -> Unit): RecyclerView.Adapter<CategoryRecyclerAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var view = LayoutInflater.from(context).inflate(R.layout.category_list_item, parent, false)
        return Holder(view, itemClick)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        return holder.bindCategory(catergories[position], context)
    }

    override fun getItemCount(): Int {
        return catergories.count()
    }

    inner class Holder(itemView: View, val itemClick:(Category) -> Unit) : RecyclerView.ViewHolder(itemView)
    {
        var categoryImage = itemView.findViewById<ImageView>(R.id.categoryImage)
        var categoryText = itemView.findViewById<TextView>(R.id.categoryText)

        fun bindCategory(category: Category, context: Context) {
            var resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)

            categoryImage.setImageResource(resourceId)
            categoryText.text = category.title
            categoryImage.setOnClickListener { itemClick(category) }
        }
    }
}