package com.example.flashcards

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.example.flashcards.R
import com.example.flashcards.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : FragmentActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: SharedViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // db setup
        val database: CovercardDatabase by lazy {
            Room.databaseBuilder(applicationContext, CovercardDatabase::class.java, "my-database")
                .build()
        }

        val dao = database.dao
        val factory = ViewModelFactory(dao)
        viewModel = ViewModelProvider(this, factory).get(SharedViewModel::class.java)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragmentContainerView)
        bottomNavView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener{ _, destination, _ ->
            if (destination.id == R.id.practiceCards) {
                bottomNavView.visibility = View.GONE
            } else {
                bottomNavView.visibility = View.VISIBLE
            }
        }

    }
}