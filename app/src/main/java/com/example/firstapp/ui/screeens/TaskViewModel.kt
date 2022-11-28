package com.example.firstapp.ui.screeens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapp.model.Task
import com.example.firstapp.model.TaskEntity
import com.example.firstapp.repositories.TaskRepository
import com.example.firstapp.utils.toListTask
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

//создали класс реализующий работу вью модели на нашем View (у нас TaskFragment)
@HiltViewModel
class TaskViewModel @Inject constructor(private var taskRepository: TaskRepository) : ViewModel() {

    //лямда выражение которое покажет успешно ли мы выполнили добавление задачи
    var taskAdded: (() -> Unit)? = null

    // создали переменную LiveData которая представляет собо "хранилище" данных, в нашем случае перечень созданных задач
    val listTaskVM = MutableLiveData<ArrayList<Task>>()

    //функция которая добавляет нашу созданную задачу(Task) и передаем ее в нашу базу данных (TaskDataBase)
    suspend fun addTaskVM(
        taskName: String, taskMessage: String, userEmail: String
    ) {
        taskRepository.addTasks(TaskEntity(0, taskName, taskMessage, Date(), userEmail))
        taskAdded?.invoke()
    }

    //создаем функцию, которая берет значение из нашей локальной базы данных, которая содержит созданные задачи
    fun getTask() {
        viewModelScope.launch {
            listTaskVM.value = taskRepository.getListTasks().toListTask()
        }
    }

    suspend fun deleteAllTask() {
        taskRepository.deleteAllListTasks()
    }

    suspend fun deleteTask(id: Int) {
        taskRepository.deleteTask(id)
    }

    var listsSearchTask = arrayListOf<Task>()

    //функция поиска созданных задач
    fun searchTask(searchTask: String) {
            listTaskVM.value = listsSearchTask.filter {
                it.nameTask.contains(searchTask) || it.messageTask.contains(searchTask)
            } as ArrayList<Task>
    }
}