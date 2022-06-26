package com.example.airbnb_team1.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.airbnb_team1.ApplicationClass.Companion.APP_DATABASE
import com.example.airbnb_team1.data.entities.Song


@Database(entities = [Song::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun songDao(): SongDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        APP_DATABASE
                    ).allowMainThreadQueries().build()
                }
            }

            return instance
        }
    }
}