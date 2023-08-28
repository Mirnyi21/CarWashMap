package com.example.carwashmap.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carwashmap.R
import com.example.carwashmap.models.ServiceWorkModel

class WorkAdapter(works : List<ServiceWorkModel>) : RecyclerView.Adapter<WorkAdapter.WorkHolder>() {

    private val workList = mutableListOf<ServiceWorkModel>()

    init {
        workList.addAll(works)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.work_card, parent, false)
        return WorkHolder(view)
    }

    override fun onBindViewHolder(holder: WorkHolder, position: Int) {
        holder.bind(workList[position])
    }

    override fun getItemCount() = workList.size

    class WorkHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ServiceWorkModel) {

            itemView.findViewById<TextView>(R.id.work_name).text = item.workName
            itemView.findViewById<TextView>(R.id.work_price).text = item.workPrice

        }
    }



}