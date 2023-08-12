package com.example.carwashmap.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carwashmap.R
import com.example.carwashmap.models.ServiceModel

class ServicesAdapter(/* передать список сервисов */) : RecyclerView.Adapter<ServicesAdapter.ServicesHolder>() {


    private val servicesList = mutableListOf<ServiceModel>()

    init {
        //servicesList.addAll(/* передай бд для заполнения */)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.service_card, parent, false)
        return ServicesHolder(view)
    }

    override fun onBindViewHolder(holder: ServicesHolder, position: Int) {
        holder.bind(servicesList[position])
    }

    override fun getItemCount() = servicesList.size

    class ServicesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ServiceModel) {

            itemView.findViewById<TextView>(R.id.service_name).text = item.serviceName
            itemView.findViewById<TextView>(R.id.service_address).text = item.serviceAddress

        }
    }

}