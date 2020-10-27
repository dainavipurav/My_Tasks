package com.android.mytasks.fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.android.mytasks.R
import com.android.mytasks.adapters.ListAdapter
import com.android.mytasks.data.Task
import com.android.mytasks.data.TaskViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment(R.layout.fragment_home), View.OnClickListener {

    private lateinit var mTextViewHomeTaskCounterHeading: TextView
    private lateinit var mTextViewHomeTaskCounterDescription: TextView
    private lateinit var mTextViewHomeLatestTaskHeading: TextView
    private lateinit var mTextViewHomeLatestTaskDescription: TextView
    private lateinit var mFloatingActionButtonHomeAddTask: FloatingActionButton
    private lateinit var mFloatingActionButtonHomeShowTaskList: FloatingActionButton

    private lateinit var mListAdapter: ListAdapter
    private var mTaskList = ArrayList<Task>()
    private lateinit var mTaskViewModel: TaskViewModel
    var mCounter : Int = 0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mTextViewHomeTaskCounterHeading = view.findViewById(R.id.textViewHomeTaskCounterHeading)
        mTextViewHomeTaskCounterDescription =
            view.findViewById(R.id.textViewHomeTaskCounterDescription)

        mTextViewHomeLatestTaskHeading = view.findViewById(R.id.textViewHomeLatestTaskHeading)
        mTextViewHomeLatestTaskDescription =
            view.findViewById(R.id.textViewHomeLatestTaskDescription)

        mFloatingActionButtonHomeAddTask = view.findViewById(R.id.floatingActionButtonHomeAddTask)
        mFloatingActionButtonHomeAddTask.setOnClickListener(this@HomeFragment)

        mFloatingActionButtonHomeShowTaskList =
            view.findViewById(R.id.floatingActionButtonHomeShowTaskList)
        mFloatingActionButtonHomeShowTaskList.setOnClickListener(this@HomeFragment)

        mTaskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        mTaskViewModel.getCount()?.observe(viewLifecycleOwner,
            Observer { integer -> mCounter = integer!!
                mTextViewHomeTaskCounterDescription.setText(integer.toString())})

        mTaskViewModel.readLatestTask.observe(viewLifecycleOwner, Observer { task ->
            if (mCounter > 0) {
                mTextViewHomeLatestTaskDescription.text = context?.getString(
                    R.string.task_list_item,
                    task.taskTitle,
                    task.taskDescription
                )
            } else {
                mTextViewHomeLatestTaskDescription.text =
                    getString(R.string.text_string_no_data_found)
            }
        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.floatingActionButtonHomeAddTask -> {
                findNavController().navigate(R.id.addFragment)
            }
            R.id.floatingActionButtonHomeShowTaskList -> {
                findNavController().navigate(R.id.listFragment)
            }
        }
    }
}