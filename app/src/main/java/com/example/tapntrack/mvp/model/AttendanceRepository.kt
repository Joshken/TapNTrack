package com.example.tapntrack.mvp.model

class AttendanceRepository {
    
    fun getAttendanceLogs(date: String): List<AttendanceLog> {
        // Mock data - in real app, this would call API
        return listOf(
            AttendanceLog("1", "1", "John Doe", "", "09:00 AM", "05:00 PM", date),
            AttendanceLog("2", "2", "Jane Smith", "", "08:30 AM", "04:30 PM", date),
            AttendanceLog("3", "3", "Mike Johnson", "", "09:15 AM", null, date)
        )
    }
    
    fun getDashboardStats(): Map<String, Int> {
        // Mock dashboard statistics - in real app, this would call API
        return mapOf(
            "totalAttendance" to 25,
            "activeUsers" to 18
        )
    }
    
    fun getUsers(): List<User> {
        // Mock user list - in real app, this would call API
        return listOf(
            User("1", "John Doe", "john@example.com", "johndoe"),
            User("2", "Jane Smith", "jane@example.com", "janesmith"),
            User("3", "Mike Johnson", "mike@example.com", "mikejohnson")
        )
    }
}
