package com.example.myapplication

import android.view.LayoutInflater
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener

internal class MyAdapter (private val myDataSet: List<String> , private val listener: OnItemClickListener):
RecyclerView.Adapter<MyAdapter.ViewHolder>() {
   internal inner class ViewHolder(val itemview: View):
        RecyclerView.ViewHolder(itemview),View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }
        val vText = itemView.findViewById(R.id.word) as TextView
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vh =  LayoutInflater.from(parent.context).inflate(R.layout.lignes, parent,false)
        return ViewHolder(vh)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var current = myDataSet[position]
        holder.vText.text = current.toString()
    }

    override fun getItemCount(): Int {
        return myDataSet.size
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}

