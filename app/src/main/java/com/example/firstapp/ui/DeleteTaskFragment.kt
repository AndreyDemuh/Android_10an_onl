package com.example.firstapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.firstapp.R

class DeleteTaskFragment: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_delete_task,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ImageView>(R.id.btnCancelDelete).setOnClickListener {
            //тут надо прописать код что бы при нажатии на кнопку удалить удалялся итем из RecyclerView
        }

        view.findViewById<ImageView>(R.id.btnDeleteTask).setOnClickListener{
            //тут надо прописать код что бы при нажатии на кнопку удалить удалялся итем из RecyclerView
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = DeleteTaskFragment()
    }


}