package com.example.pr217.model

import java.time.LocalDate
import java.time.LocalDateTime

data class appeal(
    var date: LocalDate,
    val time: LocalDateTime,
    var objectName: String,
    var applicant: String,
    var content: String,
    var responseDate: LocalDate,
    var response: String
)