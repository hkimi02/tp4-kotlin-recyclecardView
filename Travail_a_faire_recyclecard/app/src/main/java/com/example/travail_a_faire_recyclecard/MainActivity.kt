package com.example.travail_a_faire_recyclecard

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity(),MyAdapter.OnItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>
    var values= arrayListOf<HashMap<String,String>>()
    var delete: String? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val intent: Intent = intent

        if (intent.hasExtra("fromAffichestateActivity")) {
            val intent: Intent = intent
            delete = intent.getStringExtra("delete")
            //values.removeAt(Integer.parseInt(delete))
            //delete = null

        }
        fillSet()

        manager = LinearLayoutManager(this)
        myAdapter =  MyAdapter(values,this)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = manager
            adapter = myAdapter
        }

    }
    fun fillSet(){
    for (i in 1..24){
        val hashMap:HashMap<String,String> = HashMap<String,String>()
        hashMap.put("name","wileya$i")
        hashMap.put("src","image")
        values.add(hashMap)
    }
        if(this.delete!=null){
            Toast.makeText(this, "state deleted", Toast.LENGTH_SHORT).show()
            values.removeAt(Integer.parseInt(delete))
            delete=null
            Toast.makeText(this, "state deleted", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, AffichestateActivity::class.java)
        intent.putExtra("nom", values[position].getValue("name"))
        intent.putExtra("src", values[position].getValue("src"))
        intent.putExtra("position", position)
        startActivity(intent)
    }

}