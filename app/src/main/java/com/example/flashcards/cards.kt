package com.example.flashcards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flashcards.data.Covercard
import kotlinx.android.synthetic.main.fragment_cards.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [cards.newInstance] factory method to
 * create an instance of this fragment.
 */
class cards : Fragment(), CardClick{
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var adapter: CovercardAdapter
    private val viewModel by viewModels<SharedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cards, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        val card1 = Covercard(title="Hi mom", subtitle="this is the greatest card oat", count = 4, flashcards=mutableListOf())
//        val card2 = Covercard(title="Biology", subtitle="Biology class flashcards", count = 32, flashcards=mutableListOf())
//        val card3 = Covercard(title="Spanish", subtitle="Flashcards for the Spanish language", count = 21, flashcards=mutableListOf())

        val card1 = Covercard(title="Hi mom", subtitle="this is the greatest card oat", count = 4)
        val card2 = Covercard(title="Biology", subtitle="Biology class flashcards", count = 32)
        val card3 = Covercard(title="Spanish", subtitle="Flashcards for the Spanish language", count = 21)
        adapter = CovercardAdapter(mutableListOf(card1, card2, card3), this)
        recyclerViewFlashcards.adapter = adapter
        recyclerViewFlashcards.layoutManager = LinearLayoutManager(context)
        super.onViewCreated(view, savedInstanceState)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment cards.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            cards().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCardClickListener() {
        val navController = findNavController()
        viewModel.onEvent(CardEvent.EnterViewMode(navController, R.id.action_cards_to_practiceCards))
    }
}