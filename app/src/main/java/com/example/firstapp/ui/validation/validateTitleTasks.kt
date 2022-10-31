package com.example.firstapp

//функция валидирующая поле Title и возвращающая результат валидации
fun validateTitleTasks(task : String) : ValidationResult {
    return when {
        task.isBlank() -> {
            Invalid(R.string.taskName)
        }
        else -> Valid
    }
}