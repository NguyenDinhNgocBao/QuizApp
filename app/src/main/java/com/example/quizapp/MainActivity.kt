package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isEmpty
import com.example.quizapp.databinding.ActivityMainBinding

private lateinit var binding : ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {

            if(binding.tipNameEdt.text.toString().isEmpty()){
                binding.tipNameLayout.error = "Please enter your name!!!"
            }else{
                val i = Intent(this, QuizQuestions::class.java)
                i.putExtra("name", binding.tipNameEdt.text.toString())

                startActivity(i)
                finish()
            }


        }
    }
}