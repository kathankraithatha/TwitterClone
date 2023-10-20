package com.example.twitter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TweetViewModel(
    private val dao:TweetDao
):ViewModel() {
    private val _sortType= MutableStateFlow(TweetSort.TWEET)
    @OptIn(ExperimentalCoroutinesApi::class)
    private val _tweet=_sortType
        .flatMapLatest {TweetSort ->
            when(TweetSort){
                com.example.twitter.TweetSort.TWEET -> dao.getTweet()
                com.example.twitter.TweetSort.TWEETS -> TODO()
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    private val _state= MutableStateFlow(TweetState())



    fun onEvent(event: TweetEvent){
        when(event){
            is TweetEvent.DeleteTweet -> {
                viewModelScope.launch {
                    dao.deleteTweet(event.DeleteTweet)
                }
            }
            is TweetEvent.SaveByTweet -> {
                _state.update {it.copy(
                    tweet =event.SaveTweet
                )
                }
            }
            TweetEvent.SaveTweet -> {

            }
        }
    }
}