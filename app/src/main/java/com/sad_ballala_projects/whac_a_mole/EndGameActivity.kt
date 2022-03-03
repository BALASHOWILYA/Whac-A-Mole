package com.sad_ballala_projects.whac_a_mole

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sad_ballala_projects.whac_a_mole.databinding.ActivityEndGameBinding

class EndGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)
        val binding = ActivityEndGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAgain.setOnClickListener {
            val i = Intent(applicationContext, GameSceneActivity::class.java)
            startActivity(i)
        }
        binding.btnAgain.setOnClickListener {
            val i = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
        }
    }
}