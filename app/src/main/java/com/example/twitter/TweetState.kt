package com.example.twitter

data class TweetState(
    val tweetList: List<TweetNames> = emptyList(),
    val tweet: String =""
)
