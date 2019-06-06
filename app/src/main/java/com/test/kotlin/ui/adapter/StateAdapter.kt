package com.test.kotlin.ui.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.kotlin.R
import com.test.kotlin.mvvm.model.entity.State
import kotlinx.android.synthetic.main.li_state.view.*

class StateAdapter( private val onClickItem: (item: State) -> Unit) : RecyclerView.Adapter<StateAdapter.StateHolder>() {

    var list: List<State> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateHolder {
        return StateHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.li_state,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: StateHolder, position: Int) {
        holder.bind(list[holder.adapterPosition], onClickItem)
    }

    class StateHolder(view: View) : RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n")
        fun bind(item: State, onClickItem: (item: State) -> Unit) {
            itemView.tvName.text = item.name
            itemView.tvInfo.text = "${item.country} ${item.abbr}"
            itemView.tvCapital.text = item.capital
            itemView.tvLargestCity.text = item.largest_city
            itemView.tvId.text = item.id.toString()
            itemView.setOnClickListener {
                onClickItem.invoke(item)
            }
        }
    }
}