package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.question
import kotlinx.android.synthetic.main.activity_quiz.*



class quiz : AppCompatActivity(),View.OnClickListener {

    var mSelectedOption: Int? = null
    var questionnumber: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)





        setquestions(questionnumber)


        ans1.setOnClickListener(this)
        ans2.setOnClickListener(this)
        ans3.setOnClickListener(this)
        ans4.setOnClickListener(this)

        submit.setOnClickListener(this)

    }

    private fun setquestions(questionnumber: Int) {
        var questionlist = setofquestion.getquestions()
        question.text = questionlist[questionnumber].Question
        ans1.text = questionlist[questionnumber].ans1
        ans2.text = questionlist[questionnumber].ans2
        ans3.text = questionlist[questionnumber].ans3
        ans4.text = questionlist[questionnumber].ans4
        flag.setImageResource(questionlist[questionnumber].Image)
    }

    @SuppressLint("ResourceAsColor")
    override fun onClick(v: View?) {
        when(v)
        {
            ans1 -> {
                selectedoption(ans1,1);

            }
            ans2 -> {
                selectedoption(ans2,2);

            }
            ans3 -> {
                selectedoption(ans3,3);

            }
            ans4 -> {
                selectedoption(ans4,4);

            }
            submit -> {
                if(submit.text.equals("SUBMIT"))
                {
                    submittheanswer()
                }
                else
                {
                    next()
                }

            }

            else -> {Toast.makeText(applicationContext,"yo",Toast.LENGTH_SHORT).show()}
        }
    }

    private fun next() {
        var questionslist = setofquestion.getquestions()
        if(questionnumber<=questionslist.size)
        {
            questionnumber++;
            setquestions(questionnumber)
            submit.text = "SUBMIT"
        }
       else
        {
            submit.text = "GAME OVER"
        }

    }

    private fun submittheanswer() {
        if(mSelectedOption!=null)
        {
            submit.text = "NEXT"
            var questionlist = setofquestion.getquestions()

            showrightanswer(questionlist[questionnumber].correct)

            Log.d("here is the value", mSelectedOption.toString())
            when(mSelectedOption)
            {
                1-> {
                    if(ans1.text!=questionlist[questionnumber].correct)
                    {
                        ans1.setBackgroundColor(R.drawable.selected)
                    }

                }
                2-> {
                    if(ans2.text!=questionlist[questionnumber].correct)
                    {
                        ans2.setBackgroundColor(R.drawable.selected)
                    }
                }
                3-> {
                    if(ans3.text!=questionlist[questionnumber].correct)
                    {
                        ans3.setBackgroundColor(R.drawable.selected)
                    }
                }
                4-> {
                    if(ans4.text!=questionlist[questionnumber].correct)
                    {
                        ans4.setBackgroundColor(R.drawable.selected)
                    }
                }
            }

        }
    }

    private fun showrightanswer(correct: String) {
        when(correct)
        {
            ans1.text -> {ans1.setBackgroundColor(R.drawable.correct)}
            ans2.text -> {ans2.setBackgroundColor(R.drawable.correct)}
            ans3.text -> {ans3.setBackgroundColor(R.drawable.correct)}
            ans4.text -> {ans4.setBackgroundColor(R.drawable.correct)}
        }
    }

    private fun selectedoption(tv : TextView,option : Int) {
        stopeveryoption()
        tv.setBackgroundColor(R.drawable.clicked)
        mSelectedOption = option
    }
    fun stopeveryoption()
    {
        ans2.setBackgroundColor(R.drawable.stroke)
        ans3.setBackgroundColor(R.drawable.stroke)
        ans1.setBackgroundColor(R.drawable.stroke)
        ans4.setBackgroundColor(R.drawable.stroke)
    }
}
