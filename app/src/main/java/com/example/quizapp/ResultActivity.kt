package com.example.quizapp

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.databinding.ActivityResultBinding

private lateinit var binding:ActivityResultBinding
private lateinit var mediaPlayer: MediaPlayer

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getValue()

        mediaPlayer = MediaPlayer.create(this, R.raw.cheersound)
        mediaPlayer.start()

    }

    private fun getValue() {
        val name = intent.getStringExtra("name")
        val correctAns = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalQues = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)

        binding.txtName.text = name
        binding.txtScore.text = "Your Score is $correctAns out of $totalQues"

        binding.btnFinish.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            mediaPlayer.release()
        }
    }
}