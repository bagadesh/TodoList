package com.baga.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by bagadesh on 05/03/23.
 */
@Entity(tableName = "project_type")
data class ProjectType(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val projectType: String
)
