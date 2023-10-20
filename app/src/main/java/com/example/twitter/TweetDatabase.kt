package com.example.twitter

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities =[TweetNames::class],
    version = 2
)
abstract class TweetDatabase:RoomDatabase() {
    abstract val dao: TweetDao
}