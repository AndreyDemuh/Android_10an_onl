package com.example.firstapp.ui.fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentBottomSheetInfoTaskBinding
import com.example.firstapp.model.Task
import com.example.firstapp.ui.taskmanagement.DeleteTaskViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

private const val TASK_EXTRA = "task"
private const val MESSAGE_EXTRA = "message"
private const val DATE_EXTRA = "date"

class TaskInfoFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetInfoTaskBinding
    private val viewModel: DeleteTaskViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetInfoTaskBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.shareTask.setOnClickListener { onClickShareTask() }
        binding.deleteTaskDialog.setOnClickListener { onClickDeleteTask() }

        binding.taskInfoBottomSheet.text = arguments?.getString(TASK_EXTRA)
        binding.messageInfoBottomSheet.text = arguments?.getString(MESSAGE_EXTRA)
        binding.planDateBottomSheet.text = arguments?.getString(DATE_EXTRA)
    }

    companion object {

        fun getTaskInfoInstance(tasks: String, message: String, date: String): TaskInfoFragment {
            return TaskInfoFragment().apply {
                arguments = bundleOf(
                    TASK_EXTRA to tasks,
                    MESSAGE_EXTRA to message,
                    DATE_EXTRA to date
                )
            }
        }
    }

    fun onClickShareTask() {
        val sendText =
            binding.taskInfoBottomSheet.text.toString() + "\n" + binding.messageInfoBottomSheet.text.toString()
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, sendText)
        val chosenIntent = Intent.createChooser(intent, R.string.choosen_intent.toString())
        startActivity(chosenIntent)
    }

    fun onClickDeleteTask() {
        AlertDialog.Builder(requireContext())
            .setMessage(R.string.dialog_message)
            .setPositiveButton(R.string.btn_delete) { _, _ ->
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, TaskFragment())
                    .addToBackStack("")
                    .commit()
            }
            .setNegativeButton(R.string.btn_cancel) { _, _ ->

            }
            .show()
    }
}
