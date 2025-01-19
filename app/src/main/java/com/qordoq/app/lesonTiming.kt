package com.qordoq.app

import java.text.SimpleDateFormat
import java.util.*

fun isLesonStarted(startingTime: String): Boolean {
    val format = SimpleDateFormat("HH:mm", Locale.getDefault())
    val currentTime = format.format(Date())

    return currentTime == startingTime
}