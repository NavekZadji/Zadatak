package com.example.zadatak

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RvAdapter(val userList: ArrayList<String>) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.card_layout, p0, false)
        return ViewHolder(v);
    }
    override fun getItemCount(): Int {
        return userList.size
    }
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.naslov?.text = userList[p1]
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val naslov  = itemView.findViewById<TextView>(R.id.NaslovTop)

    }
}