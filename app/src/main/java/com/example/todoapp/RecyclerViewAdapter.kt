package com.example.todoapp

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo.view.*
import android.content.DialogInterface
import android.graphics.Color
import android.text.InputType
import android.util.Log
import android.widget.*


class RecyclerViewAdapter(private val applicationContext: Context, private val todolist: ArrayList<ToDoItem>): RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.todo,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemView.apply {
            msgToDo.text = todolist[position].msg
            if(!todolist[position].check) {
                msgToDo.setTextColor(Color.parseColor("#000000"))
            }
            else{
                msgToDo.setTextColor(Color.parseColor("#999999"))
            }

//            male.setOnCheckedChangeListener(new OnCheckedChangeListener(){
//
//                @Override
//                public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
//                    if (isChecked) {
//
//                        Toast.makeText(CheckBoxTuts.this, "male", Toast.LENGTH_SHORT).show();
//
//                        male.setEnabled(false);   // Will Disable checkbox
//                    }
//                }
//            }

             checkBoxToDo.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
                 override fun onCheckedChanged(p0: CompoundButton?, isChecked: Boolean) {
                     if (!isChecked){
                         msgToDo.setTextColor(Color.parseColor("#000000"))
                         todolist[position].check = false
                     }
                     else {
                         msgToDo.setTextColor(Color.parseColor("#999999"))
                         todolist[position].check = true

                     }
                 }

             })

//                checkBoxToDo.setOnClickListener {
//                if(!checkBoxToDo.isEnabled){
//                    msgToDo.setTextColor(Color.parseColor("#000000"))
//                    todolist[position].check = false
//                }
//                else {
//                    msgToDo.setTextColor(Color.parseColor("#999999"))
//                    todolist[position].check = true
//                }
//            }
        }
    }

//    fun toggleCheck(checkBox: CheckBox, textView: TextView){
//        if(!checkBox.isChecked) {
//            textView.setTextColor(Color.parseColor("#eeeeee"))
//
//        }
//        else textView.setTextColor(Color.parseColor("#000000"))
//        checkBox.toggle()
//    }
    override fun getItemCount(): Int {
        return todolist.size
    }

    override fun onBindViewHolder(
        holder: ItemViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)

        holder.itemView.apply {
            linear.setOnClickListener{
//                if(todolist[position].check) {
//                    msgToDo.setTextColor(Color.parseColor("#000000"))
//                    todolist[position].check = true
//                }
//                else{
//                    msgToDo.setTextColor(Color.parseColor("#eeeeee"))
//                    todolist[position].check = false
//                }
//                checkBoxToDo.toggle()
            }
        }

    }

}