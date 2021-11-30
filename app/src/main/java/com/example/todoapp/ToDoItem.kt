package com.example.todoapp

import android.util.Log

class ToDoItem(msg: String, check: Boolean) {

    companion object {
        var toDoList = ArrayList<ToDoItem>()

    }


    var msg: String = msg
    var check: Boolean = check

}