package com.baga.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.baga.data.db.dao.ProjectDao
import com.baga.data.db.dao.ProjectTypeDao
import com.baga.data.db.entity.ProjectData

@Database(entities = [ProjectData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun projectDao(): ProjectDao
    abstract fun projectTypeDao(): ProjectTypeDao
}