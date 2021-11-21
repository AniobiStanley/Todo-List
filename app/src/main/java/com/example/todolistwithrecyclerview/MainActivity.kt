package com.example.todolistwithrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todoList = mutableListOf(
            Todo("Follow @AniobiStanley on Twitter", false),
            Todo("Follow @AniobiStanley on GitHub", false),
            Todo("Create a GitHub account", true),
            Todo("Create a twitter account", true),
            Todo("Study Kotlin basics", true),
            Todo("Get the Covid19 Vaccine", true),
            Todo("Get a good sleep", false),
            Todo("Follow Stanley Aniobi on medium", false),
            Todo("Be my friend on FaceBook", true),
            Todo("Travel to Canada", true),
            Todo("Travel to New Zealand", true),
            Todo("Follow @AniobiStanley on Twitter", false),
            Todo("Follow @AniobiStanley on GitHub", false),
            Todo("Create a GitHub account", true),
            Todo("Create a twitter account", true),
            Todo("Study Kotlin basics", true),
            Todo("Get the Covid19 Vaccine", true),
            Todo("Get a good sleep", false),
            Todo("Follow Stanley Aniobi on medium", false),
            Todo("Be my friend on FaceBook", true),
            Todo("Travel to Canada", true),
            Todo("Travel to New Zealand", true)
        )

        val adapter = TodoAdapter(todoList)
        val rvTodo: RecyclerView = findViewById(R.id.rv_todo)
        rvTodo.adapter = adapter

        rvTodo.layoutManager = LinearLayoutManager(this)

        val btnTodo: Button = findViewById(R.id.btn_add_todo)
        val etTodo: EditText = findViewById(R.id.et_todo)

        btnTodo.setOnClickListener {
            val title = etTodo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            //adapter.notifyDataSetChanged() //updates the whole recyclerView
            adapter.notifyItemInserted(todoList.size    -1)
            etTodo.setText("")
        }
    }
}

//Add options to edit and delete at long press of item