package com.baga.data.dataSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.baga.domain.OurDate
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DateRowDataSource @Inject constructor() : PagingSource<Int, OurDate>() {
    override fun getRefreshKey(state: PagingState<Int, OurDate>): Int? {
        return 0
    }

    val batch = 6

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, OurDate> {
        println(params.key)
        val result = mutableListOf<OurDate>()
        val iKey = params.key ?: 0
        val calendar = Calendar.getInstance()
        val cTime = calendar.timeInMillis
        if (iKey >= 0) {
            for (i in iKey..iKey + batch) {
                println("Calender $i")
                result.add(
                    OurDate(
                        day = calendar.get(Calendar.DATE),
                        dateEEE = SimpleDateFormat(
                            "EEE",
                            Locale.getDefault()
                        ).format(calendar.time),
                        fullDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(
                            calendar.time
                        ),
                        isToday = cTime == calendar.timeInMillis
                    )
                )
                calendar.add(Calendar.DATE, 1)
            }

        }
        return LoadResult.Page(
            result,
            if (iKey == 0) null else iKey - 1 - batch,
            iKey + 1 + batch
        )
    }
}