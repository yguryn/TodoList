package com.example.petproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.item_todo.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, firstFragment)
            commit()
        }

        val btnNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        btnNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.miHome -> setCurrFragment(firstFragment)
                R.id.miMessages -> setCurrFragment(secondFragment)
                else -> setCurrFragment(firstFragment)
            }
            true
        }


    }

        private fun setCurrFragment(fragment: Fragment) =
            supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }





}