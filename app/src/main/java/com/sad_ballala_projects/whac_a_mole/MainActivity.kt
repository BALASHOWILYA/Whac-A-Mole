package com.sad_ballala_projects.whac_a_mole

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val play = findViewById<Button>(R.id.play)

        play?.setOnClickListener()
        {
            val i = Intent(applicationContext, GameSceneActivity::class.java)
            startActivity(i)
            Toast.makeText(this@MainActivity, R.string.message, Toast.LENGTH_LONG).show()
        }
    }

}