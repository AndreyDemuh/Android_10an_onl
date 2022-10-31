package com.example.firstapp

//функция валидирующая поле Lastname
fun validateLastNames (LastName : String) : ValidationResult {
    return when {
        LastName.isBlank() -> {
            Invalid(R.string.lastname_blank)
        }else -> Valid
    }
}