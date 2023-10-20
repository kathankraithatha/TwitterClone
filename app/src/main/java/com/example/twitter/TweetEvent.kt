package com.example.twitter

sealed interface TweetEvent {
    object SaveTweet: TweetEvent
    data class SaveByTweet(val SaveTweet:String): TweetEvent
    data class DeleteTweet(val DeleteTweet:String): TweetEvent

}