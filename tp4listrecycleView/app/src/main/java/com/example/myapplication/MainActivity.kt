package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity(),MyAdapter.OnItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>
    lateinit var Addbtn:Button
    var values= arrayListOf<String>("item1", "item2" , "item3", "item4", "item5")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        Addbtn=findViewById(R.id.ajouter)
        manager = LinearLayoutManager(this)
        myAdapter =  MyAdapter(values,this)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = manager
            adapter = myAdapter
        }
        Addbtn.setOnClickListener(){
            var n:Int = values.size + 1
            values.add("item$n")
            myAdapter.notifyItemInserted(values.size)
        }

    }
    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        values[position]="Clicked"
        myAdapter.notifyItemChanged(position)
    }
}
