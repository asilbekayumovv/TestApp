package com.example.testapp


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList


class MainActivity() : AppCompatActivity(){
    lateinit var questionsList: ArrayList<Test>
    private var index: Int = 0
    lateinit var questionModel: Test

    private var correctAnswerCount: Int = 0
    private var wrongAnswerCount: Int = 0
    lateinit var countDown: TextView
    lateinit var questions: TextView
    lateinit var var1: RadioButton
    lateinit var var2: RadioButton
    lateinit var var3: RadioButton
    lateinit var var4: RadioButton

    lateinit var nextbtn: Button
    lateinit var backbtn: Button
    lateinit var result: Button
    lateinit var radioGroup: RadioGroup

    constructor(parcel: Parcel) : this() {
        index = parcel.readInt()
        correctAnswerCount = parcel.readInt()
        wrongAnswerCount = parcel.readInt()
    }


    //    var tests:MutableList<Test> = mutableListOf()
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()


//    countDown=findViewById(R.id.countdown)
        questions = findViewById(R.id.question)
        var1 = findViewById(R.id.radioButton1)
        var2 = findViewById(R.id.radioButton2)
        var3 = findViewById(R.id.radioButton3)
        var4 = findViewById(R.id.radioButton4)
        radioGroup = findViewById(R.id.radioGroup)

        nextbtn = findViewById(R.id.nextbtn)
        backbtn = findViewById(R.id.backbtn)
        result = findViewById(R.id.result)



        questionsList = ArrayList()
        questionsList.add(
            Test(
                "44+5",
                "49",
                "50",
                "65",
                " 55",
                "50"
            )
        )
        questionsList.add(
            Test(
                "Football is ...",
                "game",
                "sport",
                "fan club",
                "TV show",
                "sport"
            )
        )
        questionsList.add(
            Test(
                "88-8",
                "80",
                "10",
                "90",
                "98",
                "80"
            )
        )
        questionsList.add(
            Test(
                "Favourite sport of creater?",
                "football",
                "basketball",
                "volleyball",
                "golf",
                "football"
            )
        )
        questionsList.add(
            Test(
                "In football footballer play ... mins",
                "45",
                "65",
                "90",
                "100",
                "90"
            )
        )

        questionModel = questionsList[index]


        nextbtn.setOnClickListener {
            index++
            this.createTest(index)


        }
        result.setOnClickListener {
            this.correctAns()
            this.gameResult()
        }



        setAllQuestions()
//    countdown()


//        tests.add(Test("Ismim nima", "Asilbek", "Joshqin", "Jonibek", "Mustaqilbek", "Asilbek"))
//
//        val question = findViewById<TextView>(R.id.question)
//        question.text = tests[0].question
//        val radio = findViewById<RadioGroup>(radioButton)
//
//        val radio2 = findViewById<RadioGroup>(R.id.radioButton2)
//        val radio3 = findViewById<RadioGroup>(R.id.radioButton3)
//        val radio4 = findViewById<RadioGroup>(R.id.radioButton4)
    }

    private fun createTest(index: Int) {
        if (index < questionsList.size) {
            val test = questionsList[index]
            questions.text = test.question
            var1.text = test.var1
            var2.text = test.var2
            var3.text = test.var3
            var4.text = test.var4
        }

    }

    private fun correctAns() {
        wrongAnswerCount++
    }

    private fun wrongAns() {
        correctAnswerCount++
    }

    private fun gameResult() {
        var intent1 = Intent(this, Result::class.java)

        intent1.putExtra("correct", correctAnswerCount.toString())
        intent1.putExtra("total", questionsList.size.toString())

        startActivity(intent1)
    }



    @SuppressLint("SuspiciousIndentation")
    fun option1Clicked(view: View) {

        if (questionModel.var1 == questionModel.answer) {
            correctAns()

        } else {
            wrongAns()
        }
    }

    fun option2Clicked(view: View) {

        if (questionModel.var2 == questionModel.answer) {
            correctAns()

        } else {
            wrongAns()
        }
    }

    fun option3Clicked(view: View) {

        if (questionModel.var3 == questionModel.answer) {
            correctAns()


        } else {
            wrongAns()
        }
    }

    @SuppressLint("SuspiciousIndentation")
    fun option4Clicked(view: View) {

        if (questionModel.var4 == questionModel.answer) {
            correctAns()

        } else {
            wrongAns()
        }
    }

    private fun setAllQuestions() {
        var1.text = questionModel.var1
        var2.text = questionModel.var2
        var3.text = questionModel.var3
        var4.text = questionModel.var4
        questions.text = questionModel.question

    }


}


