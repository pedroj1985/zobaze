package com.zobaze.zobazerefractortask.ui

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zobaze.zobazerefractortask.api.Employee


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: ArrayList<Employee>) {
    val adapter = recyclerView.adapter as EmployeeAdapter
    adapter.submitList(data)
}