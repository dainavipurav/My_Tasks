package com.android.mytasks.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.android.mytasks.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment(R.layout.fragment_home), View.OnClickListener {

    private lateinit var mTextViewHomeTaskCounterHeading : TextView
    private lateinit var mTextViewHomeTaskCounterDescription : TextView
    private lateinit var mTextViewHomeLatestTaskHeading : TextView
    private lateinit var mTextViewHomeLatestTaskDescription : TextView
    private lateinit var mFloatingActionButtonHomeAddTask : FloatingActionButton
    private lateinit var mFloatingActionButtonHomeShowTaskList : FloatingActionButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mTextViewHomeTaskCounterHeading = view.findViewById(R.id.textViewHomeTaskCounterHeading)
        mTextViewHomeTaskCounterDescription = view.findViewById(R.id.textViewHomeTaskCounterDescription)

        mTextViewHomeLatestTaskHeading = view.findViewById(R.id.textViewHomeLatestTaskHeading)
        mTextViewHomeLatestTaskDescription = view.findViewById(R.id.textViewHomeLatestTaskDescription)

        mFloatingActionButtonHomeAddTask = view.findViewById(R.id.floatingActionButtonHomeAddTask)
        mFloatingActionButtonHomeAddTask.setOnClickListener(this@HomeFragment)

        mFloatingActionButtonHomeShowTaskList = view.findViewById(R.id.floatingActionButtonHomeShowTaskList)
        mFloatingActionButtonHomeShowTaskList.setOnClickListener(this@HomeFragment)


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.floatingActionButtonHomeAddTask ->
            {
                findNavController().navigate(R.id.action_homeFragment_to_addFragment2)
            }
            R.id.floatingActionButtonHomeShowTaskList ->
            {
                findNavController().navigate(R.id.action_homeFragment_to_listFragment2)
            }
        }
    }
}