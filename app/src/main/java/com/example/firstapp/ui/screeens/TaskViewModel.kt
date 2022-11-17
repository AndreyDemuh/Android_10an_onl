package com.example.firstapp.ui.screeens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapp.model.Task
import com.example.firstapp.model.TaskEntity
import com.example.firstapp.repositories.TaskRepository
import com.example.firstapp.utils.toListTask
import kotlinx.coroutines.launch

//создали класс реализующий работу вью модели на нашем View (у нас TaskFragment)
class TaskViewModel : ViewModel() {

    //создали переменную repository, которая ссылается на слой TaskRepository()
    private val repository = TaskRepository()

    // создали переменную LiveData которая представляет собо "хранилище" данных, в нашем случае перечень созданных задач
    val listTaskVM = MutableLiveData<ArrayList<Task>>()

    //создаем функцию, которая берет значение из нашей локальной базы данных, которая содержит созданные задачи
    fun getTask() {
        viewModelScope.launch {
            listTaskVM.value = repository.getListTasks().toListTask()
        }
    }

    var listsSearchTask = arrayListOf<Task>()

    //функция поиска созданных задач
    fun searchTask(searchTask: String) {
            listTaskVM.value = listsSearchTask.filter {
                it.nameTask.contains(searchTask) || it.messageTask.contains(searchTask)
            } as ArrayList<Task>
    }
}