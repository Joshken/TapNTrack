package com.example.tapntrack.mvp.model

data class AttendanceLog(
    val id: String,
    val userId: String,
    val userName: String,
    val userAvatar: String,
    val checkInTime: String,
    val checkOutTime: String?,
    val date: String
)
