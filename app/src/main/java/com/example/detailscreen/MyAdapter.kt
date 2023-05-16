package com.example.detailscreen

import android.content.Context
import android.content.Intent
import android.media.Image
import android.os.Build.VERSION_CODES.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView



class MyAdapter(val ctx: Context, val userList:List<Result>):RecyclerView.Adapter<MyAdapter.ViewHolder>() {
     class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var Name:TextView
        var Email:TextView
        var fulclick: ConstraintLayout
        init {
            Name=itemView.findViewById(R.id.name)
            Email=itemView.findViewById(R.id.email)
            fulclick=itemView.findViewById(R.id.fullclick)
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(ctx).inflate(R.layout.row_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Name.text=userList[position].name.title+" "+userList[position].name.first+" "+userList[position].name.last
        holder.Email.text=userList[position].email

        holder.fulclick.setOnClickListener{
            if (position==0)
            {
                val secondactivity = Intent(ctx,userDetail::class.java)
                secondactivity.putExtra("name",userList[position].name.title+""+userList[position].name.first+" "+userList[position].name.last)
                secondactivity.putExtra("email",userList[position].email)
                secondactivity.putExtra("gender",userList[position].gender)
                secondactivity.putExtra("cell",userList[position].cell)
                secondactivity.putExtra("phone",userList[position].phone)
                secondactivity.putExtra("nat",userList[position].nat)
                secondactivity.putExtra("dob",userList[position].dob.date)
                secondactivity.putExtra("registered",userList[position].registered.date)
                secondactivity.putExtra("image",userList[position].picture.large)
                secondactivity.putExtra("login",userList[position].login.md5)
                secondactivity.putExtra("id",userList[position].id.name)

                secondactivity.putExtra("location",userList[position].location.city)
                ctx.startActivity(secondactivity)
            }
            else if (position==1)
            {
                val secondactivity = Intent(ctx,userDetail::class.java)
                secondactivity.putExtra("name",userList[position].name.title+""+userList[position].name.first+" "+userList[position].name.last)
                secondactivity.putExtra("email",userList[position].email)
                secondactivity.putExtra("gender",userList[position].gender)
                secondactivity.putExtra("cell",userList[position].cell)
                secondactivity.putExtra("phone",userList[position].phone)
                secondactivity.putExtra("nat",userList[position].nat)
                secondactivity.putExtra("dob",userList[position].dob.date)
                secondactivity.putExtra("image",userList[position].picture.large)
                secondactivity.putExtra("registered",userList[position].registered.date)
                secondactivity.putExtra("login",userList[position].login.md5)
                secondactivity.putExtra("id",userList[position].id.name)
                secondactivity.putExtra("location",userList[position].location.city)
                ctx.startActivity(secondactivity)
            }
        }


    }

    override fun getItemCount(): Int {
        return userList.size
    }
}


