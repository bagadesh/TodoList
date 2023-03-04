package com.baga.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by bagadesh on 04/03/23.
 */
@Entity
data class ProjectData(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "project_type") val projectType: String,
    @ColumnInfo(name = "due_date") val dueDate: String,
)
