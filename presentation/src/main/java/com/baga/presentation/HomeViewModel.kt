package com.baga.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.baga.data.dataSource.DateRowDataSource
import com.baga.domain.OurDate
import com.baga.domain.entity.thingsTodo.Todo
import com.baga.presentation.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val dSource: DateRowDataSource,
) : BaseVM() {

    fun getDates(): Flow<PagingData<OurDate>> {
        return Pager(config = PagingConfig(1)) {
            dSource
        }.flow
    }
    val data: ArrayList<Todo> = arrayListOf(
        Todo(
            "123",
            "Book an Appointment",
            whenHappening = "Tomorrow"
        ),
        Todo(
            "124",
            "Book an Appointment",
            whenHappening = "Tomorrow"
        ),
        Todo(
            "123",
            "Book an Appointment",
            whenHappening = "Tomorrow"
        )
    )
    fun getThingsList() : List<Todo> {
        return data
    }
    fun onCheckBoxClick(todo: Todo) {
        data.find {
            it.todoId == todo.todoId
        }?.let {
            it.isChecked = true
        }
    }
}