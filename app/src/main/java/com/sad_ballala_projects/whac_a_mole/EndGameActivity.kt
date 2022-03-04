package com.sad_ballala_projects.whac_a_mole

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sad_ballala_projects.whac_a_mole.databinding.ActivityEndGameBinding

class EndGameActivity : AppCompatActivity() {
    val APP_PREFERENCES = "txtValue"
    val APP_PREFERENCES_THE_BEST_SCORE = "record"
    val APP_PREFERENCES_SCORE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)
        val binding = ActivityEndGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAgain.setOnClickListener {
            val i = Intent(applicationContext, GameSceneActivity::class.java)
            startActivity(i)
        }
        binding.btnMain.setOnClickListener {
            val i = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
        }
        val i = intent
        val currentScore = i.getIntExtra("result", APP_PREFERENCES_SCORE)
        var record = 0

        if(currentScore == 1) binding.txtCurrentScore.text = "Your current Score is $currentScore point"
        else binding.txtCurrentScore.text = "Your current Score is $currentScore points"


        val scoreResult = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        val editor = scoreResult.edit()


        if (!scoreResult.contains(APP_PREFERENCES_THE_BEST_SCORE)) return

        record = scoreResult.getInt(APP_PREFERENCES_THE_BEST_SCORE, APP_PREFERENCES_SCORE)

        if(currentScore < record){

            if(record == 1) binding.txtRecord.text = "Your record is $record point"
            else binding.txtRecord.text = "Your record is $record points"

        }
        else{

            if(record == 1) binding.txtRecord.text = "Your new record is $currentScore point"
            else binding.txtRecord.text = "Your new record is $currentScore points"

        }









        editor.putInt(APP_PREFERENCES_THE_BEST_SCORE, currentScore)
        editor.apply()









    }
}