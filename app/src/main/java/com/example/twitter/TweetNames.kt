package com.example.twitter

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TweetNames(
    val tweetContent:String,
    @PrimaryKey(autoGenerate = true)
    val id:Int=0

)
