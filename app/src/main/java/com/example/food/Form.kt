package com.example.food

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_form.*
import org.json.JSONArray
import org.json.JSONObject

class Form : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        Submit.setOnClickListener(){
            var jsonObj = JSONObject("{ \"name\":"+nameIn.getText().toString()+", \"category\": "+CategoryIn.getText().toString()+", \"url\": "+URLIN.getText().toString()+" }")
             var jstr: String = Food().getJsonFromAssets("Food.Json", this);
            val  FoodJson  = JSONObject(jstr);
            val foodList: JSONArray = FoodJson.getJSONArray("foods")
            foodList.put(jsonObj)
           // var finalJson = JSONObject("{\"foods\":"+foodList.toString()+"\"}");
            var finalJson = JSONObject().put("Foods", foodList).put("reciepe",FoodJson.getJSONArray("reciepe") )

            //foodList.toJSONObject("Foods")
            Log.d("JSONObj",""+finalJson.toString() )

        }

    }
}