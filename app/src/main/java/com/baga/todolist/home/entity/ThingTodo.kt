package com.baga.todolist.home.entity

data class ThingTodo(
    val taskName: String,
    val date: String,
    val description: String = "",
    val checked: Boolean = false
)