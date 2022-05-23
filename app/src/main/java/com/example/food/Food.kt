package com.example.food

import android.content.Context
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import java.nio.Buffer


class Food {
    lateinit var name: String
    lateinit var url : String
    lateinit var category: String
    constructor(_name: String,_url : String, _category: String){
        name = _name;
        url = _url
        category= _category
    }

    constructor()

    fun getFoodItems(Filename : String, context: Context) : ArrayList<Food>{
        var FoodArray = ArrayList<Food>()
     var jstr: String = getJsonFromAssets(Filename, context);
        val  FoodJson  = JSONObject(jstr);
        val foodList:JSONArray = FoodJson.getJSONArray("foods")
        for (i in 0 until foodList.length()) {
            val food = foodList.getJSONObject(i)
            FoodArray.add(Food(food.get("name").toString(), food.get("url").toString(), food.get("category").toString()))
           // println("${book.get("book_name")} by ${book.get("author")}")
        }
        Log.d("Json", foodList.toString())
        return  FoodArray
    }

    fun getJsonFromAssets(filename : String, context : Context): String{
        var jstr: String ?= null;
        val instream =  context.assets.open(filename)

        //creating a buffer to read the stream of the size of input stream
        val size = instream.available()

        val Buffer = ByteArray(size);

        instream.read(Buffer);
        instream.close()
    jstr = String(Buffer,Charsets.UTF_8)
        return jstr
    }
}