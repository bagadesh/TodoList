package com.baga.domain.entity.thingsTodo

data class Todo(
    val todoId: String,
    val title: String,
    val description: String = "",
    val whenHappening: String,
    var isChecked: Boolean = false
)
