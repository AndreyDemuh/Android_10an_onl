package com.example.firstapp.ui.screeens

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentBottomSheetInfoTaskBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date

private const val TASK_EXTRA = "task"
private const val MESSAGE_EXTRA = "message"
private const val DATE_EXTRA = "date"
private const val TASK_ID = "task_id"

class TaskInfoFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetInfoTaskBinding
    private var taskId: Int? = null
    private val viewModel: TaskViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
        taskId = arguments?.getInt(TASK_ID)
    }

    companion object {

        fun getTaskInfoInstance(
            tasks: String,
            message: String,
            date: Date,
            id: Int
        ): TaskInfoFragment {
            return TaskInfoFragment().apply {
                arguments = bundleOf(
                    TASK_EXTRA to tasks,
                    MESSAGE_EXTRA to message,
                    DATE_EXTRA to date,
                    TASK_ID to id
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
                lifecycleScope.launch(Dispatchers.IO) { viewModel.deleteTask(taskId!!) }
            }
            .setNegativeButton(R.string.btn_cancel) { _, _ ->
            }
            .show()
    }
}
