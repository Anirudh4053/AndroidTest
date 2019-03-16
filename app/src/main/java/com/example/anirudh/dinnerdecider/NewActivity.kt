package com.example.anirudh.dinnerdecider

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class NewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)


        //tut 17 numbers and operator

        val a = 12
        val b = 25

        println(b + a)
        println(b - a)
        println(b / a)
        println(b * a)

        //modular
        println(b % a)

        //simple function
        smaplefunc();

        //passing arg
        makeEnter("make sample text")

        //returning Int
        println("CalVal "+calculateNumbers(4,5))
        //or
        val d = calculateNumbers(4,5)
        println("CalVal1 $d")
        //or
        println("CalVal2 ${calculateNumbers(4,5)}")


        //wiith no default value
        customDefault()
        //or
        customDefault("happy")



        //tut20 condition logic
        condition()


        //tut21 collection kotlin
        //arrays
        //imutable listr
        val list = listOf("Panaji","Margao","Mapusa","Pernem")
        //forsortedlist
        println(list.sorted())//Mapusa, Margao, Panaji, Pernem
        println(list[2])
        println(list.first())
        println(list.last())
        println(list.contains("Panaji"))//true
        println(list)

        //mutable list which can be modified
        val mutList = arrayListOf("Goa","Delhi","Mumbai","Karnataka")
        println(mutList.size)
        mutList.add("Kerala")
        println(mutList)
        mutList.add(0,"Gujrat")//Gujrat, Goa, Delhi, Mumbai, Karnataka, Kerala
        println(mutList)
        println(mutList.indexOf("Goa"))
        mutList.remove("Mumbai")
        println(mutList)


        //map - collection of keyvalue pair unorderpairs
        //imutable
        // key to value
        val map = mapOf("solo" to "Millienium Falcon","Luke" to "Landspeeder")
        println(map["solo"])
        //or
        println(map.get("solo"))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            println(map.getOrDefault("Lieah","this ship does not exit"))
        }
        //get key or values
        println(map.keys)
        println(map.values)


        //mutable map change the value
        val mmap = hashMapOf("solo" to "Millienium Falcon","Luke" to "Landspeeder","bobba" to "Rocket pack")
        mmap["Luke"] = "xwing"
        mmap.put("lehia","TantivIV")
        println(mmap)
        mmap.remove("bobba")
        println(mmap)
        //mmap.clear()
        //mmap.isEmpty()



        //tut 22 loops
        for (a in mutList){
            println("Name: $a")
        }
        for ((key,value) in mmap){
            println("$key $value")
        }
        var x=10
        while (x>0){
            println(x)
            x--
        }


        //tut 23 nullability
        var name:String = "Anirudh"
        //name=null

        //? this type can be nullable
        var nullableName:String?="Do I really exit"
        nullableName = null
        println(nullableName)

        //null check
        var length = 0
        if(nullableName!=null) {
            length = nullableName.length
        }
        else{
            length = -1
        }
        println(length)
        //or
        val l = if(nullableName!=null) nullableName else -1
        println(l)

        //second method is safe call operator ?
        println(nullableName?.length)

        //third method is Elvis operator
        val len = nullableName?.length ?:-1
        val nname = nullableName?:"no one knows me"
        println("len $len")
        println("len $nname")

        //!! used for force unwrapping in ios dev
        //this will crash becoz ur forcing them
        //println(nullableName!!.length)


        //class n inheritance
        /*val car = Car("Toyota","Avalon","red")
        println(car.make)
        println(car.model)
        car.accelerate()
        car.Details()*/


        //call instance of car class
        val tesla = Car("Tesla","ModelS","Red")
        tesla.accelerate()

        val truck = Truck("Ford","F44",350)
        //tesla.accelerate()
        truck.Tow()




        //tut 22 lamba expression
        //lamba is alway surrounded with curlly bracess
        //parameter->body return type
        val printMessage = {message:String-> println(message)}
        printMessage("hello world!")
        val sum = {a:Int,b:Int->a+b}
        println(sum(1,2))
        //or
        val sumB : (Int,Int)->Int = {x,y->x+y}
        println(sumB(3,6))

        //return null or void
        fun downloadData(url:String,completion:()->Unit){

            //send a downoadrequest
            //we got data
            //there were no network errors
            completion()
        }

        //call dowloadData
        downloadData("fakurl.com",{
            println("the codein the block will only run after the completion()")
        })

        fun downloadCar(url:String,completion:(Car)->Unit){
            //send a download reqest
            //we got the back cardata
            val car = Car("Tesla","ModelX","Blue")
            completion(car)
        }
        downloadCar("fakeurl.com"){car ->
            //update the ui get data
            println(car.color)
            println(car.make)

        }
        //it is used if only one parametr
        /*downloadCar("fakeurl.com"){
            //update the ui get data
            println(it.color)
            println(it.make)

        }*/



        fun downloadTruckData(url:String,completion:(Truck?,Boolean)->Unit){
            //make a web request
            //get the result back
            val webRequestSucess = true;
            if(webRequestSucess){
                //recieve truck data
                val truck = Truck("Ford","Xyx",444)
                completion(truck,true)
            }
            else{
                //if we dont have truckobject
                completion(null,false)
            }
        }
        downloadTruckData("fackurl.com"){ truck, success ->
            if(success){
                //do somthing with ourtruck
                truck?.Tow()
            }
            else{
                //failure msg
                printMessage("something went wrong")
            }
        }
    }
    //tu 18 functions
    fun smaplefunc(){
        println("Sample function")
    }

    //line is the argument
    fun makeEnter(line: String){
        println(line)
    }

    //when we are returning an object eg in this case Integer :Int
    fun calculateNumbers(a:Int,b:Int):Int{
        val c = a+b
        return c
    }


    //tut20 condition
    fun condition(){
        val a = 2
        val b = 2
        if(a == b){
            println("a is equal to b")
        }
        if(a!=b){
            println("a is not equal to b")
        }


        val x = 3
        when(x){
            //if 1 then print
            1-> println("x is 1")
            2-> println("x is 2")
            else->println("x is not 1 or 2")
        }
    }


    fun customDefault(moood:String = "angry"){
        println("mode $moood")
    }

}

//created a class
/*class Car(make:String,model:String){
    val make = make
    val model = model

}*/
//or
/*class Car(val make: String, val model: String,val color:String){


    fun accelerate(){
        println("vroom vroom")
    }
    fun Details(){
        println("This is $make $model with $color color")
    }
}*/
//u dont have getter setter


//class veh that will inher the car
// by default all classes are finel so we write open
open class Vehicle(val make:String,val model:String){
    //open to overide in child class
    open fun accelerate(){
        println("vroom vroom")
    }
    fun park(){
        println("Parking the vehicle")
    }
    fun brake(){
        println("Stop")
    }
}
//inherit fromvehicle
class Car(make:String,model:String,var color:String):Vehicle(make,model){

    override fun accelerate() {
        super.accelerate()
        println("Slow Car vroom")
    }
}
class Truck(make:String,model:String,val towingcap:Int):Vehicle(make,model){
    fun Tow(){
        println("vehicle tow")
    }
}
