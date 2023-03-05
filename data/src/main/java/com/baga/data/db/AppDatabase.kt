package com.baga.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.baga.data.db.dao.ProjectDao
import com.baga.data.db.dao.ProjectTypeDao
import com.baga.data.db.entity.ProjectData
import com.baga.data.db.entity.ProjectType

@Database(entities = [ProjectData::class, ProjectType::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun projectDao(): ProjectDao
    abstract fun projectTypeDao(): ProjectTypeDao
}