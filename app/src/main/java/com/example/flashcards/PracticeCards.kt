package com.example.flashcards

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flashcards.data.Flashcard
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_cards.*
import kotlinx.android.synthetic.main.fragment_cards.recyclerViewFlashcards
import kotlinx.android.synthetic.main.fragment_practice_cards.*
import kotlinx.android.synthetic.main.fragment_practice_cards.view.*
import library.StackLayoutManager

class PracticeCards : Fragment() {

    companion object {
        fun newInstance() = PracticeCards()
    }

    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_practice_cards, container, false)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bottomNavigationView?.visibility = View.GONE
        viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)
        val card1 = Flashcard("who is the first man on the moon?", "your mom.", null)
        val card2 = Flashcard("how are you today?", "This is the greatest answer of all time", null)
        val card3 = Flashcard("do you want to be great?", "Yes.", null)
        val card4 = Flashcard("What will it take?", "Everything.", null)

        val adapter = PracticeCardsAdapter(
            mutableListOf(
                card1,
                card2,
                card3,
                card4
            )
        )
        recyclerViewFlashcards.adapter = adapter
        recyclerViewFlashcards.layoutManager = StackLayoutManager()
        // todo: fix this index and use something more professional
        var index = 0
        buttonCorrectAnswer.setOnClickListener{
            index += 1
            recyclerViewFlashcards.scrollToPosition(index)
        }
        buttonWrongAnswer.setOnClickListener{
            index -= 1
            recyclerViewFlashcards.scrollToPosition(index)

        }

    }


}
