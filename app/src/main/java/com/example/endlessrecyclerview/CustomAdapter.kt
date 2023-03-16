package com.example.endlessrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(
    private val lightColor: Int,
    private val darkColor: Int
) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var items: List<Pair<String, String>> = emptyList()

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvLeftItem: TextView
        val tvRightItem: TextView

        init {
            tvLeftItem = view.findViewById(R.id.tvLeftItem)
            tvRightItem = view.findViewById(R.id.tvRightItem)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_layout, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvLeftItem.text = items[position].first
        viewHolder.tvRightItem.text = items[position].second
        if (position % 2 == 0) {
            viewHolder.tvLeftItem.setBackgroundColor(darkColor)
            viewHolder.tvRightItem.setBackgroundColor(lightColor)
        } else {
            viewHolder.tvLeftItem.setBackgroundColor(lightColor)
            viewHolder.tvRightItem.setBackgroundColor(darkColor)
        }
    }

    override fun getItemCount() = items.size

    fun setData(newItems: List<Pair<String, String>>) {
        items = newItems
        notifyDataSetChanged()
    }

}