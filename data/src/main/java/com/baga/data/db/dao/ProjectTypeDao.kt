package com.baga.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.baga.data.db.entity.ProjectType

/**
 * Created by bagadesh on 05/03/23.
 */
@Dao
interface ProjectTypeDao {

    @Query("SELECT * from project_type")
    suspend fun getAllProjectTypes(): List<ProjectType>

    @Insert
    suspend fun insertAll(vararg projectType: ProjectType)

    @Delete
    suspend fun delete(projectType: ProjectType)

}