package com.example.firstapp.utils

import java.text.SimpleDateFormat
import java.util.*

fun Date.convertToSimpleDate(): String {
    val formatDate = SimpleDateFormat("dd-MM-yyyy")
    return formatDate.format(this)
}