package com.example.wordle

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View;
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn = findViewById<Button>(R.id.submitBtn)

        // initiate guess variables
        val guess1 = findViewById<TextView>(R.id.guess1)
        val guess2 = findViewById<TextView>(R.id.guess2)
        val guess3 = findViewById<TextView>(R.id.guess3)

        // initiate guess label
        var check1Label = findViewById<TextView>(R.id.guess1CheckLabel)
        var check2Label = findViewById<TextView>(R.id.guess2CheckLabel)
        var check3Label = findViewById<TextView>(R.id.guess3CheckLabel)


        // initiate check label variables
        var guess1Label = findViewById<TextView>(R.id.guess1Label)
        var guess2Label = findViewById<TextView>(R.id.guess2Label)
        var guess3Label = findViewById<TextView>(R.id.guess3Label)


        // guess check label
        var check1 = findViewById<TextView>(R.id.guess1Check)
        var check2 = findViewById<TextView>(R.id.guess2Check)
        var check3 = findViewById<TextView>(R.id.guess3Check)

        // initiate variables
        var answer = findViewById<TextView>(R.id.answer)


        // Random Word
        val ww = FourLetterWorldList.FourLetterWordList
        var word = ww.getRandomFourLetterWord()


//        var message = findViewById<TextView>(R.id.textView2);
        var buttonclick = 0;
        var textinput = findViewById<EditText>(R.id.editText)




//
        answer.text = word
        fun checkGuess(guess: String, wordToGuess: String) : String {
            var result = ""
            for (i in 0..3) {
                if (guess[i] == wordToGuess[i]) {
                    result += "O"
//                    print(guess[i] + "vs" + wordToGuess[i])

                }
                else if (guess[i] in wordToGuess) {
                    result += "+"

                }
                else {
                    result += "X"
                    println(guess[i] + "vs" + wordToGuess[i])
                }
            }
            return result
        }

        var reset = 0;

        btn.setOnClickListener {
            buttonclick++
            if (buttonclick == 1) {
                guess1.text = textinput.text
                guess1.visibility = View.VISIBLE
                guess1Label.visibility = View.VISIBLE
                check1Label.visibility = View.VISIBLE;
                check1.text = checkGuess(textinput.text.toString(), word)
                check1.visibility = View.VISIBLE
            }
            if (buttonclick == 2) {
                guess2.text = textinput.text
                guess2.visibility = View.VISIBLE
                guess2Label.visibility = View.VISIBLE
                check2Label.visibility = View.VISIBLE;
                check2.text = checkGuess(textinput.text.toString(), word)
                check2.visibility = View.VISIBLE
            }
            if (buttonclick == 3) {
                guess3.text = textinput.text
                guess3.visibility = View.VISIBLE
                guess3Label.visibility = View.VISIBLE
                check3Label.visibility = View.VISIBLE
                check3.text = checkGuess(textinput.text.toString(), word)
                check3.visibility = View.VISIBLE
                answer.visibility = View.VISIBLE
                buttonclick = 0;
                btn.text = "RESET"
                btn.setBackgroundColor((Color.parseColor("#606060")))
                reset = 1;
            }

//            if (reset == 1) {
//
//                word = ww.getRandomFourLetterWord()
//                guess2Label.visibility = View.INVISIBLE
//                guess3Label.visibility = View.INVISIBLE
//                guess1.visibility = View.INVISIBLE
//                guess2.visibility = View.INVISIBLE
//                guess3.visibility = View.INVISIBLE
//                check1.visibility = View.INVISIBLE
//                check2.visibility = View.INVISIBLE
//                check3.visibility = View.INVISIBLE
//                check1Label.visibility = View.INVISIBLE
//                check2Label.visibility = View.INVISIBLE
//                check3Label.visibility = View.INVISIBLE
//                btn.text = "SUBMIT"
//                btn.setBackgroundColor((Color.parseColor("A908B5")))
//                textinput.text.clear()
//               reset = 0
//
//
//            }




        }

    }

}