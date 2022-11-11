package com.example.firstapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstapp.model.Task
import com.example.firstapp.repositories.TaskRepository

//создали класс реализующий работу вью модели на нашем View (у нас TaskFragment)
class TaskViewModel : ViewModel() {

    //создали переменную repository, которая ссылается на слой TaskRepository()
    private val repository = TaskRepository()

    // создали переменную LiveData которая представляет собо "хранилище" данных, в нашем случае перечень созданных задач
    val listTaskVM = MutableLiveData<ArrayList<Task>>()

    //создаем функцию, которая берет значение из нашей локальной базы данных, которая содержит созданные задачи
    fun getTask() {
        listTaskVM.value = repository.getListTasks()
    }
}