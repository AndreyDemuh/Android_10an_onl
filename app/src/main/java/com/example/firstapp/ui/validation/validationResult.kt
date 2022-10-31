package com.example.firstapp

sealed class ValidationResult
object Valid : ValidationResult()
class   Invalid(val textError: Int) : ValidationResult()