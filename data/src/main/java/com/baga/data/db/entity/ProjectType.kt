package com.baga.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

/**
 * Created by bagadesh on 05/03/23.
 */
@Entity
data class ProjectType(
    @ColumnInfo(name = "project_type") val projectType: String
)
