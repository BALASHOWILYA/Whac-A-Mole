package com.sad_ballala_projects.whac_a_mole

import android.content.Intent
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageButton
import androidx.core.content.res.ResourcesCompat
import com.sad_ballala_projects.whac_a_mole.databinding.ActivityFirstGameSceneBinding
import kotlin.random.Random

class GameSceneActivity : AppCompatActivity() {
    private lateinit var btnImageArray: Array<ImageButton>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_game_scene)
        val binding = ActivityFirstGameSceneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnImageArray = arrayOf(
            binding.btnMolePart011,
            binding.btnMolePart012,
            binding.btnMolePart013,
            binding.btnMolePart014,
            binding.btnMolePart015,
            binding.btnMolePart016,
            binding.btnMolePart017,
            binding.btnMolePart018,
            binding.btnMolePart019
        )
        var VisibleMole = 0
        var scoreText = 0

        for (button in btnImageArray) {
            button.setOnClickListener {
                if (btnImageArray[VisibleMole].isEnabled && btnImageArray[VisibleMole] == it) {
                    scoreText += 1
                    binding.scoreText.text= "Your score is: ${scoreText}"
                    btnImageArray[VisibleMole].isEnabled = false
                    btnImageArray[VisibleMole].setImageResource(R.drawable.mole_part_02)
                }
            }
        }

        object : CountDownTimer(30000, 500) {
            override fun onTick(millisUntilFinished: Long) {
                btnImageArray[VisibleMole].isEnabled = false
                btnImageArray[VisibleMole].setImageResource(R.drawable.mole_part_01)
                binding.timeText.text = "Time: ${millisUntilFinished / 1000}"
                var newMole = Random.nextInt(9)
                while (newMole == VisibleMole) newMole = Random.nextInt(5)
                VisibleMole = newMole

                showNewMole(mole = VisibleMole)
            }

            override fun onFinish() {
                val i = Intent(applicationContext, EndGameActivity().javaClass)
                i.putExtra("Your score is", scoreText.toString())
                startActivity(i)
            }
        }.start()



    }

    private fun showNewMole(mole: Int) {
        val btn = btnImageArray[mole]
        btn.isEnabled = true
        val layers = arrayOfNulls<Drawable>(2)

        layers[0] = ResourcesCompat.getDrawable(resources, R.drawable.mole_part_03, null)
        layers[1] = ResourcesCompat.getDrawable(resources, R.drawable.mole_part_04, null)

        val transition = TransitionDrawable(layers)
        transition.isCrossFadeEnabled = true
        btn.setImageDrawable(transition)
        transition.startTransition(180)
    }
}