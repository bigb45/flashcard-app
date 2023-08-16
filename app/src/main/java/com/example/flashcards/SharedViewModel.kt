package com.example.flashcards

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashcards.data.Covercard
import com.example.flashcards.data.Flashcard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SharedViewModel(val dao: CovercardDao) : ViewModel() {
    var flashcards: MutableLiveData<MutableList<Flashcard>> = MutableLiveData()
    var covercards: MutableLiveData<MutableList<Covercard>> = MutableLiveData()
    var currentFlashcard: MutableLiveData<Flashcard> = MutableLiveData()
    //    fun markAnswer(card: Flashcard, answeredCorrectly: Boolean){
//        card.answeredCorrectly = answeredCorrectly
//    }

    private val _appState = MutableStateFlow(FlashcardsState())
    fun onEvent(event: CardEvent){
        when(event){
            is CardEvent.EnterViewMode -> {
                event.navigator.navigate(event.destination)
            }
            is CardEvent.EnterAddMode -> TODO()
            is CardEvent.EnterCreateMode -> TODO()
            is CardEvent.AddFlashCards -> {
                viewModelScope.launch {
                    Log.d("adding covercard", "")
                    dao.insertCovercard(Covercard(2, "this is a test", "this is still a test", 42))
                }
            }
        }
    }
}