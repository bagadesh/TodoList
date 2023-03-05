package com.baga.todolist.home.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.baga.data.dataSource.DateRowDataSource
import com.baga.domain.OurDate
import com.baga.domain.entity.thingsTodo.Todo
import com.baga.todolist.home.BottomSheetType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by bagadesh on 04/03/23.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val dSource: DateRowDataSource,
) : ViewModel() {

    val bottomSheetType = mutableStateOf(BottomSheetType.ADD_TASK)

    fun getDates(): Flow<PagingData<OurDate>> {
        return Pager(config = PagingConfig(1)) {
            dSource
        }.flow
    }
    val data: ArrayList<Todo> = arrayListOf(
        Todo(
            "122",
            "Book an Appointment",
            whenHappening = "Tomorrow"
        ),
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
            "125",
            "Book an Appointment",
            whenHappening = "Tomorrow"
        ),
        Todo(
            "126",
            "Book an Appointment",
            whenHappening = "Tomorrow"
        ),
        Todo(
            "127",
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