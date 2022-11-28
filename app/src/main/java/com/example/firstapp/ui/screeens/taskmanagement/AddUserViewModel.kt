package com.example.firstapp.ui.screeens.taskmanagement

import androidx.lifecycle.ViewModel
import com.example.firstapp.model.User
import com.example.firstapp.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddUserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    var userAdded: (() -> Unit)? = null

    //функция которая добавляет Юзера и передаем ее в нашу базу данных (TaskDataBase)
    suspend fun addUserVM(userEmail: String) {
        userRepository.addUsers(User(userEmail))
        userAdded?.invoke()
    }
    //функция которая добавляет нашу созданную задачу(Task) и передаем ее в нашу базу данных (TaskDataBase)
    suspend fun deleteUser(email: String) {
        userRepository.deleteUser(email)
    }
}