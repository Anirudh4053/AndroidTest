package com.example.anirudh.dinnerdecider

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var name="anirudh"
    //or
    //var name:String="anirudh"
    var istrue = true

    var a = 3
    //or
    //var a:Int  = 3
    var b = 3

    val doubleNum = 123.56 //64 bit number
    val floatNum = 123.56f //32 bit number
    val longNum = 1235636563673L //64 bit number


    var foodList = arrayListOf("Chinese","hamburger","Pizza","Mac","Xyz")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //selectedFoodTxt.text = "Anirudh"

        println("is "+name+" awasome "+istrue)
        println(a+b)

        decideBtn.setOnClickListener {
            println("You Clicked me")
            val random = Random()
            val randomFood = random.nextInt(foodList.count())
            selectedFoodTxt.text = foodList[randomFood]
        }
        addFoodBtn.setOnClickListener {
            val newFood = addFoodTxt.text.toString()
            foodList.add(newFood)
            addFoodTxt.text.clear()
            println(foodList)
        }
        next.setOnClickListener {
            next()
        }
        val str = "May the force be with you"
        //val str = "May the force be \"with\" you"
        //val str = "May the force be \n with you" new line
        //val str = "May the force be \t with you" tab space
        //val str = "May the force be \b with you" back space
        //val str = "May the force be \r with you" will output with you
        //val str = "May the force be \$ with you" for $ sign
        println(str)

        //for raw text
        //.trimMargin will automatically remove all the intend spaces add | symbol at the begining of the line
        val rawText = """|A long time ago,
            |in a galaxy
            |far, far, away...""".trimMargin()

        //or
        /*val rawText = """>A long time ago,
            >in a galaxy
            >far, far, away...""".trimMargin(">")*/
        println(rawText)


        /*for(char in str){
            println(char)
        }*/

        //to check if string are equal
        val contentEquals = str.contentEquals("May the force be with you")
        println(contentEquals)

        //ignore uppercase is true
        val contains = str.contains("force",true)
        println("contains "+contentEquals)

        val uppercase = str.toUpperCase()
        val lowercase = str.toLowerCase()
        println(uppercase +"\n"+lowercase )


        var subsequence = str.subSequence(4,13)
        println(subsequence)
        //the force


        //string templeate
        val luke = "Luke skywalker"
        val lightsabercolor = "green"
        val vehicle = "landspeeder"

        println("$luke has a $lightsabercolor lightsaber and drive a $vehicle")
        println("Lukes full name $luke has ${luke.length}")


    }
    fun next(){
        val intent = Intent(this,NewActivity::class.java)
        startActivity(intent)
    }
}

/*
val is imutable ->values set cannot be changed
var is mutable values can be changed
*/