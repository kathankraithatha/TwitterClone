package com.example.twitter

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

object TweetDatabaseSingleton {
    private var instance:TweetDatabase?=null
    @OptIn(InternalCoroutinesApi::class)
    fun getInstance(context: Context):TweetDatabase{
        return instance ?: synchronized(this){
            instance ?: Room.databaseBuilder(
                context.applicationContext,
                TweetDatabase::class.java,
                "tweetDatabase.db"
            ).fallbackToDestructiveMigration().build()
        }
    }
}