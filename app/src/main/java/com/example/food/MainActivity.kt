package com.example.food


import FoodAdapter
import android.content.Intent
import android.os.Bundle

import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.sql.DataSource


class MainActivity : AppCompatActivity() {
    lateinit var listView : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Next.setOnClickListener(){
            val nextIntent = Intent(this, Form::class.java)
            startActivity(nextIntent)
        }

        listView = findViewById(R.id.list)

        var food = Food()
        var foodlist = food.getFoodItems("Food.Json", this )

//
        var list: Array<Map<String, String>?> = arrayOfNulls<Map<String, String>>(foodlist.size)
        for((index,value) in foodlist.withIndex())
        {
            var item = HashMap<String, String>()
            item.put("name", value.name)
            item.put("categary", value.category)
            list[index] = item
//
        }

        val foodAdapter = FoodAdapter(this,foodlist)
        listView.adapter = foodAdapter
//        var simpleadapter =  SimpleAdapter(
//            this,
//            list.toMutableList(),
//            android.R.layout.simple_list_item_2,
//            arrayOf("name", "categary"),
//            intArrayOf(android.R.id.text1, android.R.id.text2)
//        )


//        listView.adapter = simpleadapter

//    val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_2, android.R.id.text1, nameList)
//        listView.adapter = adapter
//       Log.d("Array food","done")


    }
}