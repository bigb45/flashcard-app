package com.example.flashcards

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flashcards.data.Covercard
import com.example.flashcards.data.Flashcard

class SharedViewModel : ViewModel() {
    var flashcards: MutableLiveData<MutableList<Flashcard>> = MutableLiveData()
    var covercards: MutableLiveData<MutableList<Covercard>> = MutableLiveData()
    var currentFlashcard: MutableLiveData<Flashcard> = MutableLiveData()

    fun markAnswer(card: Flashcard, answeredCorrectly: Boolean){
        card.answeredCorrectly = answeredCorrectly
    }



    fun nextCard(){

    }
}