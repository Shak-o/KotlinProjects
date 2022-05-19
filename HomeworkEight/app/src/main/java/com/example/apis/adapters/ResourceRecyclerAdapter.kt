package com.example.apis.adapters

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apis.R
import com.example.apis.activities.ResourceActivity
import com.example.apis.api.dtos.ResourceData

class ResourceRecyclerAdapter(private val resources: List<ResourceData>) : RecyclerView.Adapter<ResourceRecyclerAdapter.ResourceViewHolder>() {
    companion object {
        const val RESOURCE_ID = "RESOURCE_ID"
    }
    class ResourceViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }
        private val name : TextView = itemView.findViewById(R.id.textView4)
        private val color : TextView = itemView.findViewById(R.id.textView6)
        private val year : TextView = itemView.findViewById(R.id.textView7)
        private val pantone : TextView = itemView.findViewById(R.id.textView8)
        private lateinit var resource : ResourceData

        fun onBind(resource: ResourceData){
            name.text = resource.name
            color.text = resource.color
            color.setTextColor(Color.parseColor(resource.color))
            year.text = resource.year.toString()
            pantone.text = resource.pantone_value
            this.resource = resource
        }
        override fun onClick(clickedView: View?) {
            val context = itemView.context
            val intent = Intent(context, ResourceActivity :: class.java)
            intent.putExtra(RESOURCE_ID, resource.id)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResourceViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_resource, parent, false)
        return ResourceRecyclerAdapter.ResourceViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ResourceViewHolder, position: Int) {
        holder.onBind(resources[position])
    }

    override fun getItemCount(): Int {
        return resources.size
    }

}