package com.example.flashcards

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.animation.doOnEnd
import androidx.recyclerview.widget.RecyclerView
import com.example.flashcards.data.Flashcard
import kotlinx.android.synthetic.main.covercard.view.*
import kotlinx.android.synthetic.main.flashcard.view.*

class PracticeCardsAdapter(
    var flashcardsList: MutableList<Flashcard>
) : RecyclerView.Adapter<PracticeCardsAdapter.PracticeCardsViewHolder>() {
    class PracticeCardsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PracticeCardsViewHolder {
        return PracticeCardsViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.flashcard,
                    parent,
                    false
                )
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: PracticeCardsViewHolder, position: Int) {
        val newCard = flashcardsList[position]
        val animation = AnimatorInflater.loadAnimator(
            holder.itemView.context,
            R.animator.front_animator
        ) as AnimatorSet

        animation.setTarget(holder.itemView)
        var frontSide = true

        holder.itemView.apply {
            textViewMainText.text = newCard.question
            textViewCardFace.text = "Question"
            "${position + 1}/${itemCount}".also { textViewCardIndex.text = it }
        }

        holder.itemView.setOnClickListener {
            it.cameraDistance = 8000 * it.resources.displayMetrics.density

            if (frontSide) {
               animation.start()
                frontSide = false
                changeCard(newCard.answer, "Answer", holder.itemView)
            } else {
                animation.start()
                frontSide = true
                changeCard(newCard.question, "Question", holder.itemView)
            }
        }
    }


    private fun changeCard(cardText: String, cardType: String, itemView: View) {
        val valueAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 1000
            addUpdateListener { animator ->
                val animatedValue = animator.animatedValue as Float
                if (animatedValue >= 0.5) {
                    itemView.textViewCardFace.text = cardType
                    itemView.textViewMainText.text = cardText
                }
            }
        }

        valueAnimator.start()

    }

    override fun getItemCount(): Int {
        return flashcardsList.size
    }
}