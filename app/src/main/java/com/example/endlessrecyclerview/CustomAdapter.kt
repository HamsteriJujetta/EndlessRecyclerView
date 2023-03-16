package com.example.endlessrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var items: List<NumInterface> = emptyList()

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvLeftItem: TextView
        val tvRightItem: TextView

        init {
            // Define click listener for the ViewHolder's View
            tvLeftItem = view.findViewById(R.id.tvLeftItem)
            tvRightItem = view.findViewById(R.id.tvRightItem)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_layout, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.tvLeftItem.text = items[position].leftNum
        viewHolder.tvRightItem.text = items[position].rightNum
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = items.size

    fun setData(newItems: List<NumInterface>) {
        items = newItems
        notifyDataSetChanged()
    }

}