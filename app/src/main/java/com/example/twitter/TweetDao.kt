package com.example.twitter

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import org.intellij.lang.annotations.Flow

@Dao
interface TweetDao {
    @Upsert
    suspend fun updateTweet(tweet: TweetNames)
    @Delete
    suspend fun deleteTweet(tweet: String)
    @Query("SELECT * FROM tweetnames ORDER BY tweetContent")
    fun getTweet():kotlinx.coroutines.flow.Flow<List<TweetNames>>

}