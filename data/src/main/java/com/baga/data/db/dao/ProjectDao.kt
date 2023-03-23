package com.baga.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.baga.data.db.entity.ProjectData

/**
 * Created by bagadesh on 04/03/23.
 */
@Dao
interface ProjectDao {

    @Query("SELECT * from projectdata")
    suspend fun getAll(): List<ProjectData>

    @Insert
    suspend fun insertAll(vararg projectData: ProjectData)

    @Delete
    fun delete(projectData: ProjectData)

    @Query("delete from projectdata where id in (:projectIds)")
    fun deleteProjectById(projectIds: List<Int>)

}