package com.android.mytasks.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.android.mytasks.R
import com.android.mytasks.adapters.ListAdapter
import com.android.mytasks.data.Task
import com.android.mytasks.data.TaskViewModel

class ListFragment : Fragment(R.layout.fragment_list) {


    private lateinit var mConstraintLayoutList : ConstraintLayout
    private lateinit var mRecyclerViewList : RecyclerView
    private lateinit var mTextViewList : TextView
    private lateinit var mTaskViewModel: TaskViewModel

    private var mCounter: Int =0
    private lateinit var mListAdapter: ListAdapter
    private var mTaskList = ArrayList<Task>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mConstraintLayoutList = view.findViewById(R.id.constraintLayoutList)
        mRecyclerViewList = view.findViewById(R.id.recyclerViewList)
        mTextViewList = view.findViewById(R.id.textViewList)

        mTaskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        mTaskViewModel.getCount()?.observe(viewLifecycleOwner,
            Observer { integer -> mCounter = integer!! })

        if (mCounter==0){
            mTextViewList.visibility = View.GONE
            mRecyclerViewList.visibility = View.VISIBLE
        }
        else{
            mTextViewList.visibility = View.VISIBLE
            mRecyclerViewList.visibility = View.GONE
        }


        context?.let {
            mListAdapter = ListAdapter(
                it,
                mTaskList
            )
            mRecyclerViewList.adapter = mListAdapter

            mTaskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
            mTaskViewModel.readAllTasks.observe(viewLifecycleOwner, Observer {task->
                mListAdapter.setData(task)
            })

        }



    }
}