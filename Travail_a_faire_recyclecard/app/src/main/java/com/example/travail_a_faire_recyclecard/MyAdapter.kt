package com.example.travail_a_faire_recyclecard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

internal class MyAdapter(private val myDataSet: List<HashMap<String,String>>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    internal inner class ViewHolder(val itemview: View):
        RecyclerView.ViewHolder(itemview),View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }
        val StateCard = itemView.findViewById(R.id.cardState) as CardView
        val imageState=itemview.findViewById(R.id.imageState) as ImageView
        val NameState=itemview.findViewById(R.id.NameState) as TextView
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vh =  LayoutInflater.from(parent.context).inflate(R.layout.card_state, parent,false)
        return ViewHolder(vh)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var current = myDataSet[position]
        val imageName = current.getValue("src")
        val id = holder.itemView.context.resources.getIdentifier(imageName, "drawable", holder.itemView.context.packageName)
        holder.imageState.setImageResource(id)
        holder.NameState.text=current.getValue("name")
    }

    override fun getItemCount(): Int {
        return myDataSet.size
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}