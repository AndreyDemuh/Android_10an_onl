package com.example.firstapp

//функция валидирующая поле name
fun validateNames(name : String) : ValidationResult {
    return when {
        name.isBlank() -> {
            Invalid(R.string.name_blank)
        }else -> Valid
    }
}