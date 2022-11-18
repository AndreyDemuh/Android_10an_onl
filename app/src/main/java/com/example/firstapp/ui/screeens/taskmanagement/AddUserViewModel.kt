package com.example.firstapp.ui.screeens.taskmanagement

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapp.model.User
import com.example.firstapp.repositories.UserRepository
import kotlinx.coroutines.launch

class AddUserViewModel : ViewModel() {

    //создали переменную repository, которая ссылается на слой TaskRepository()
    private val repository = UserRepository()

    var userAdded: (() -> Unit)? = null

    //функция которая добавляет Юзера и передаем ее в нашу базу данных (TaskDataBase)
    suspend fun addUserVM(userEmail: String) {
        repository.addUsers(User(userEmail))
        userAdded?.invoke()
    }
    //функция которая добавляет нашу созданную задачу(Task) и передаем ее в нашу базу данных (TaskDataBase)
    suspend fun deleteUser(email: String) {
        repository.deleteUser(email)
    }
}