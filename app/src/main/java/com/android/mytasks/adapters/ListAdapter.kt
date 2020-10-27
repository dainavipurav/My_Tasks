package com.android.mytasks.adapters

import android.app.Activity
import android.app.Application
import android.content.Context
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.mytasks.R
import com.android.mytasks.data.Task
import kotlinx.android.synthetic.main.custom_list_item.view.*

class ListAdapter(var mContext: Context, var mTaskList : List<Task>) : RecyclerView.Adapter<ListAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.custom_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.textViewCustomListItemTaskTitle.text =
            mTaskList[position].taskTitle

        holder.itemView.textViewCustomListItemTaskDescription.text =
            mTaskList[position].taskDescription
    }

    override fun getItemCount(): Int {
        return mTaskList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    fun setData(task : List<Task>){
        this.mTaskList = task
        notifyDataSetChanged()
    }


}