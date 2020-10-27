package com.android.mytasks.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import com.android.mytasks.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class AddFragment : Fragment(R.layout.fragment_add),View.OnClickListener {

    private lateinit var mConstraintLayoutAdd : ConstraintLayout
    private lateinit var mTextInputLayoutAddTaskTitle : TextInputLayout
    private lateinit var mTextInputEditTextAddTaskTitle : TextInputEditText
    private lateinit var mTextInputLayoutAddTaskDescription : TextInputLayout
    private lateinit var mTextInputEditTextAddTaskDescription : TextInputEditText
    private lateinit var mButtonAddTaskAdd : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mConstraintLayoutAdd = view.findViewById(R.id.constraintLayoutAdd)
        mTextInputLayoutAddTaskTitle = view.findViewById(R.id.textInputLayoutAddTaskTitle)
        mTextInputEditTextAddTaskTitle = view.findViewById(R.id.textInputEditTextAddTaskTitle)

        mTextInputLayoutAddTaskDescription = view.findViewById(R.id.textInputLayoutAddTaskDescription)
        mTextInputEditTextAddTaskDescription = view.findViewById(R.id.textInputEditTextAddTaskDescription)

        mButtonAddTaskAdd = view.findViewById(R.id.buttonAddTaskAdd)
        mButtonAddTaskAdd.setOnClickListener(this@AddFragment)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.buttonAddTaskAdd ->
            {
                Toast.makeText(context,"Added",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        findNavController().popBackStack()
    }
}