package com.android.mytasks.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.android.mytasks.R
import com.android.mytasks.data.Task
import com.android.mytasks.data.TaskViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class AddFragment : Fragment(R.layout.fragment_add),View.OnClickListener {

    private lateinit var mConstraintLayoutAdd : ConstraintLayout
    private lateinit var mTextInputLayoutAddTaskTitle : TextInputLayout
    private lateinit var mTextInputEditTextAddTaskTitle : TextInputEditText
    private lateinit var mTextInputLayoutAddTaskDescription : TextInputLayout
    private lateinit var mTextInputEditTextAddTaskDescription : TextInputEditText
    private lateinit var mButtonAddTaskAdd : Button

    private lateinit var mTaskViewModel: TaskViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mConstraintLayoutAdd = view.findViewById(R.id.constraintLayoutAdd)
        mTextInputLayoutAddTaskTitle = view.findViewById(R.id.textInputLayoutAddTaskTitle)
        mTextInputEditTextAddTaskTitle = view.findViewById(R.id.textInputEditTextAddTaskTitle)

        mTextInputLayoutAddTaskDescription = view.findViewById(R.id.textInputLayoutAddTaskDescription)
        mTextInputEditTextAddTaskDescription = view.findViewById(R.id.textInputEditTextAddTaskDescription)

        mButtonAddTaskAdd = view.findViewById(R.id.buttonAddTaskAdd)
        mButtonAddTaskAdd.setOnClickListener(this@AddFragment)

        mTaskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.buttonAddTaskAdd ->
            {
                isAddTaskValidated()
            }
        }
    }

    private fun isAddTaskValidated() {
        if (mTextInputEditTextAddTaskTitle.text.toString().isEmpty())
        {
            mTextInputLayoutAddTaskTitle.isErrorEnabled = true
            mTextInputLayoutAddTaskTitle.error = getString(R.string.text_string_field_cant_be_empty)
        }
        else if (mTextInputEditTextAddTaskDescription.text.toString().isEmpty())
        {
            mTextInputLayoutAddTaskDescription.isErrorEnabled = true
            mTextInputLayoutAddTaskDescription.error = getString(R.string.text_string_field_cant_be_empty)
        }
        else{
            insertTaskToDatabase()
        }
    }

    private fun insertTaskToDatabase() {

        val task = Task(
            0,
            mTextInputEditTextAddTaskTitle.text.toString(),
            mTextInputEditTextAddTaskDescription.text.toString()
        )

        mTaskViewModel.addTask(task)
        Toast.makeText(context,"Added",Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.homeFragment)
    }
}