package com.example.firstapp

//функция валидирующая поле Message и возвращающая результат валидации
fun validateMessageTasks(message : String) : ValidationResult {
    return when {
        message.isBlank() -> {
            Invalid(R.string.message_task)
        }
        else -> Valid
    }
}