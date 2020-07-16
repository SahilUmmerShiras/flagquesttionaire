package com.example.myapplication

object setofquestion {

    fun getquestions() : ArrayList<question>
    {
        var questionlist  = ArrayList<question>()
        val question1 = question(" What country is this?", "India","italy", "China", "USA",R.drawable.india,"India")
        val question2 = question(" What country is this?", "India","italy", "China", "Japan",R.drawable.china,"China")
        val question3 = question(" What country is this?", "India","italy", "China", "Japan",R.drawable.japan,"Japan")
        val question4 = question(" What country is this?", "India","italy", "China", "USA",R.drawable.italy,"Italy")

        questionlist.add(question1);
        questionlist.add(question2)
        questionlist.add(question3)
        questionlist.add(question4)

        return questionlist
    }

}