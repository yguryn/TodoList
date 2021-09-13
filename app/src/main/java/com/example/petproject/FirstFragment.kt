package com.example.petproject

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petproject.data.Todo
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.item_todo.*

class FirstFragment : Fragment(R.layout.fragment_first) {

    var todoList = mutableListOf(
        Todo("Learn about LiveData1"),
        Todo("Learn about LiveData2"),
        Todo("Learn about LiveData3"),
        Todo("Learn about LiveData4"),
        Todo("Learn about LiveData5"),
        Todo("Learn about LiveData6"),
        Todo("Learn about LiveData7"),
        Todo("Learn about LiveData8"),
        Todo("Go for temp work")
    )

    val adapter = TodoAdapter(todoList)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_first, container, false)
        setHasOptionsMenu(true)

        val recycler = view?.findViewById<RecyclerView>(R.id.rvTodos)


        recycler?.adapter = adapter
        recycler?.layoutManager = LinearLayoutManager(requireContext())
        return view


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        for(i in 0 until todoList.size) {
            if(adapter.getValue(i)) adapter.notifyItemRemoved(i)
        }
        adapter.notifyDataSetChanged()
        Log.d("Smth", "${adapter.todos[0].isChecked}")

        return super.onOptionsItemSelected(item)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu);

        super.onCreateOptionsMenu(menu, inflater)
    }

    fun checkBox() {

    }




}