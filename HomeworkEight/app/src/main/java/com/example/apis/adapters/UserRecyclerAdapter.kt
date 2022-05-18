package com.example.apis.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apis.R
import com.example.apis.activities.UserActivity
import com.example.apis.api.dtos.Data
import com.example.apis.api.dtos.User
import com.example.apis.api.dtos.UserList
import com.squareup.picasso.Picasso

class UserRecyclerAdapter(private val users: List<Data>) : RecyclerView.Adapter<UserRecyclerAdapter.UserViewHolder>() {
    companion object {
        const val USER_ID = "USER_ID"
    }
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        init {
            itemView.setOnClickListener(this)
        }
        private val image :ImageView = itemView.findViewById(R.id.imageView)
        private val fullName : TextView = itemView.findViewById(R.id.textView)
        private val mail : TextView = itemView.findViewById(R.id.textView2)
        private lateinit var user: Data

        fun onBind(user: Data){
            fullName.text = "${user.first_name} ${user.last_name}"
            mail.text = user.email
            Picasso.get().load(user.avatar).into(image);
            this.user = user
        }

        override fun onClick(clickedView: View?) {
            val context = itemView.context
            val intent = Intent(context, UserActivity :: class.java)
            intent.putExtra(USER_ID, user.id)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }
}