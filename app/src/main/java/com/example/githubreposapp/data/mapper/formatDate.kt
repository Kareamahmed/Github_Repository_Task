package com.example.githubreposapp.data.mapper

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun formatDate(inputDate: String): String {
    val inputFormatter = DateTimeFormatter.ISO_ZONED_DATE_TIME // Handles "2024-02-27T10:00:00Z"
    val outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, hh:mm a") // Desired format

    val parsedDate = ZonedDateTime.parse(inputDate, inputFormatter)
    return parsedDate.format(outputFormatter)
}