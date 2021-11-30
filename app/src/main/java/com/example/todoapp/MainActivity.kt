package com.example.todoapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.CheckBox
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var myRV: RecyclerView
    lateinit var floatingActionButton: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("TODOLIST", "onCreate List is ${ToDoItem.toDoList.size}")


       // checkBox.isChecked = false
       // checkBox.isEnabled = false
        myRV = findViewById<RecyclerView>(R.id.rvMain)
        myRV.layoutManager = LinearLayoutManager(this)
        myRV.adapter = RecyclerViewAdapter(this, ToDoItem.toDoList)

        floatingActionButton = findViewById(R.id.floatingToDo)
        floatingActionButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("New Item")

            // Set up the input
            val input = EditText(this)
            // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
            input.inputType = InputType.TYPE_CLASS_TEXT
            builder.setView(input)

            // Set up the buttons

            builder.setPositiveButton("OK") {
                dialog, which -> ToDoItem.toDoList.add(ToDoItem(input.text.toString(), false))
            }
            builder.setNegativeButton("Cancel") {
                    dialog, which -> dialog.cancel()
            }

            builder.show()
        }



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.delete -> {
//                Log.println(Log.DEBUG, "TOTOTO", "line #1 the size of ToDoList is: ${ToDoItem.toDoList.size}")
//
//                var temp = ArrayList<ToDoItem>()
//                Log.println(Log.DEBUG, "TOTOTO", "line #2 the size of temp is: ${temp.size}")
//
//                for(i in 0..ToDoItem.toDoList.size-1){
//                    Log.println(Log.DEBUG, "TOTOTO", "#$i = ${ToDoItem.toDoList[i].check}")
//                    if(!ToDoItem.toDoList[i].check) {
//                        temp.add(ToDoItem.toDoList[i])
//                        Log.println(Log.DEBUG, "TOTOTO", "#$i added to temp!")
//                    }
//                }
//
//                Log.println(Log.DEBUG, "TOTOTO", "line #3 the size of temp is: ${temp.size}")
//                ToDoItem.toDoList.clear()
//                Log.println(Log.DEBUG, "TOTOTO", "line #4 the size of ToDoList is: ${ToDoItem.toDoList.size}")
//
//                ToDoItem.toDoList.addAll(temp)
//                Log.println(Log.DEBUG, "TOTOTO", "line #54 the size of ToDoList is: ${ToDoItem.toDoList.size}")
//                Log.println(Log.DEBUG, "TOTOTO", "=====================================================")

                ToDoItem.toDoList.clear() //<--- delete this
                myRV.adapter?.notifyDataSetChanged()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}