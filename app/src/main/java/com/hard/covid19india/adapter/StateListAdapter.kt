package com.hard.covid19india.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hard.covid19india.R
import com.hard.covid19india.model.StateWise


class StateListAdapter(val context: Context, val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<ViewHolder>() {
    private var items: List<StateWise?>? = null

    interface OnItemClickListener {
        fun onItemClick(item: StateWise?)
    }

    public fun updateData(data: List<StateWise?>?){
        items = data;
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return if(items == null){
            0;
        }else{
            items!!.size
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.state_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items!![position],itemClickListener)
    }

}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
    val tvStateName : TextView = view.findViewById(R.id.textStateName)
    val tvConfirmedCount : TextView = view.findViewById(R.id.textConfirmedCount)
    val tvActiveCount : TextView = view.findViewById(R.id.textActiveCount)
    val tvRecoveredCount : TextView = view.findViewById(R.id.textRecoveredCount)

    fun bind(stateWise: StateWise?,clickListener: StateListAdapter.OnItemClickListener)
    {
        tvStateName.text = stateWise!!.getState()
        tvActiveCount.text = stateWise.getActive()

        if(stateWise!!.getDeltaconfirmed()!!.toInt() > 0){
            val updatedStr = stateWise!!.getConfirmed() + "  [+" +stateWise.getDeltaconfirmed()+"]"
            tvConfirmedCount.text = updatedStr
        }else{
            tvConfirmedCount.text = stateWise.getConfirmed()
        }
        if(stateWise.getDeltarecovered()!!.toInt() > 0){
            val updatedStr = stateWise.getRecovered() + "  [+" +stateWise.getDeltarecovered()+"]"
            tvRecoveredCount.text = updatedStr
        }else{
            tvRecoveredCount.text = stateWise.getRecovered()
        }

        itemView.setOnClickListener {
            clickListener.onItemClick(stateWise)
        }
    }


}
