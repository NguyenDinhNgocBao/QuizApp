package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapp.databinding.ActivityQuizQuestionsBinding

private lateinit var binding:ActivityQuizQuestionsBinding
private lateinit var mediaPlayer:MediaPlayer


class QuizQuestions : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Questions>? = null
    private var mSelectedPosition:Int = 0
    private var mCorrectAnswer:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")

        binding.txtName.text = name


        mQuestionList = Constants.getQuestions()

        setValue()

        binding.txtOption1.setOnClickListener(this)
        binding.txtOption2.setOnClickListener(this)
        binding.txtOption3.setOnClickListener(this)
        binding.txtOption4.setOnClickListener(this)


        binding.btnSubmit.setOnClickListener(this)
    }


    private fun setValue() {

        val questions = mQuestionList!![mCurrentPosition - 1]

        //đặt thay đổi khi click vào 1 lựa chọn nào đó
        defaultOptionView()

        if(mCurrentPosition == mQuestionList!!.size){
            binding.btnSubmit.text = "FINISH"
        }else{
            binding.btnSubmit.text = "Submit"
        }

        binding.progressBar.progress = mCurrentPosition
        binding.txtProgress.text = "$mCurrentPosition" + "/" + binding.progressBar.max

        binding.imageCity.setImageResource(questions!!.image)
        binding.txtQuestion.text = questions!!.question
        binding.txtOption1.text = questions!!.optionOne
        binding.txtOption2.text = questions!!.optionTwo
        binding.txtOption3.text = questions!!.optionThree
        binding.txtOption4.text = questions!!.optionFour
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        //Add vào options
        options.add(0, binding.txtOption1)
        options.add(1, binding.txtOption2)
        options.add(2, binding.txtOption3)
        options.add(3, binding.txtOption4)

        for(option in options){
            option.setTextColor(Color.parseColor("#555555"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_border
            )
        }

    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.txtOption1 -> {
                selectedOptionView(binding.txtOption1, 1)
            }
            R.id.txtOption2 -> {
                selectedOptionView(binding.txtOption2, 2)
            }
            R.id.txtOption3 -> {
                selectedOptionView(binding.txtOption3, 3)
            }
            R.id.txtOption4 -> {
                selectedOptionView(binding.txtOption4, 4)
            }
            R.id.btnSubmit -> {
                if(mSelectedPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionList!!.size ->{
                            setValue()
                        }else -> {
                            Toast.makeText(this,"Bạn đã hoàn thành", Toast.LENGTH_LONG).show()
                            val i = Intent(this,ResultActivity::class.java)
                            i.putExtra("name",binding.txtName.text.toString())
                            i.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswer)
                            i.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                            startActivity(i)
                        }
                    }
                }else{
                    val questions = mQuestionList?.get(mCurrentPosition - 1)

                    if(questions!!.correctAns != mSelectedPosition){
                        checkAnswer(mSelectedPosition, R.drawable.wrong_option_border)
                        Toast.makeText(this,"Bạn đã chọn sai!!",Toast.LENGTH_LONG).show()
                        mediaPlayer = MediaPlayer.create(this, R.raw.wrongsound)
                        mediaPlayer.start()
                    }else{
                        mCorrectAnswer++
                        mediaPlayer = MediaPlayer.create(this, R.raw.correctsound)
                        mediaPlayer.start()
                    }
                    checkAnswer(questions.correctAns, R.drawable.correct_option_border)

                    if(mCurrentPosition == mQuestionList!!.size){
                        binding.btnSubmit.text = "FINISH"

                    }else{
                        binding.btnSubmit.text = "NEXT"
                    }
                    mSelectedPosition = 0
                }
            }
        }
    }

    private fun checkAnswer(answer:Int, drawableView : Int) {
        when(answer){
            1 -> {
                binding.txtOption1.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                binding.txtOption2.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                binding.txtOption3.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                binding.txtOption4.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv : TextView, selectedOptionNum:Int) {
        defaultOptionView()
        mSelectedPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#333333"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selector
        )
    }
}