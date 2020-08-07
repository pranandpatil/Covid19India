package com.hard.covid19india.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hard.covid19india.R
import com.hard.covid19india.model.DistrictData

class DistrictListAdapter(val context: Context) :
    RecyclerView.Adapter<DistrictViewHolder>() {

    private var items: List<DistrictData?>? = null

    public fun updateData(data: List<DistrictData?>?){
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DistrictViewHolder {
        return DistrictViewHolder(LayoutInflater.from(context).inflate(R.layout.district_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DistrictViewHolder, position: Int) {
        holder.bind(items!![position])
    }

}

class DistrictViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvDistrictName: TextView = view.findViewById(R.id.textDistrictName)
    val tvConfirmedCount: TextView = view.findViewById(R.id.textConfirmedCount)


    fun bind(districtData : DistrictData?) {
        tvDistrictName.text = districtData!!.getDistrict()
        tvConfirmedCount.text = districtData.getConfirmed().toString()
    }


}
