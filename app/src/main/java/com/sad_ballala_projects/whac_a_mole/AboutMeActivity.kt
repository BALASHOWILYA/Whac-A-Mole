package com.sad_ballala_projects.whac_a_mole

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import com.sad_ballala_projects.whac_a_mole.databinding.ActivityAboutMeBinding

class AboutMeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)
        val binding =ActivityAboutMeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtGitHub.movementMethod = LinkMovementMethod.getInstance()
        binding.txtEmail.movementMethod = LinkMovementMethod.getInstance()
        binding.txtTelegram.movementMethod = LinkMovementMethod.getInstance()
        binding.txtVk.movementMethod = LinkMovementMethod.getInstance()

    }

}