package com.example.flashcards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.flashcards.data.Covercard
import kotlinx.android.synthetic.main.covercard.view.*


class CovercardAdapter(
    private val covercards: MutableList<Covercard>,
    private val navController: NavController
) : RecyclerView.Adapter<CovercardAdapter.CovercardViewHolder>() {
    class CovercardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovercardViewHolder {
        return CovercardViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.covercard,
                parent,
                false
            )
        )
    }

    private fun clickListener(){
        navController.navigate(R.id.action_cards_to_practiceCards)
    }
    override fun onBindViewHolder(holder: CovercardViewHolder, position: Int) {
        val covercard = covercards[position]
        holder.itemView.setOnClickListener { clickListener() }

        holder.itemView.apply {
            textViewCardTitle.text = covercard.title
            textViewCardSubtitle.text = covercard.subtitle
            "${covercard.count} cards".also { buttonPracticeCard.text = it }
            buttonPracticeCard.setOnClickListener{ clickListener() }
        }
    }

    override fun getItemCount(): Int {
        return covercards.size
    }

}