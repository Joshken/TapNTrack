package com.example.tapntrack.mvp.model

class UserRepository {
    
    fun authenticate(username: String, password: String): User? {
        // Mock authentication - in real app, this would call API
        return if (username.isNotEmpty() && password.isNotEmpty()) {
            User("1", "Admin User", "admin@example.com", username)
        } else {
            null
        }
    }
    
    fun registerUser(fullName: String, email: String, username: String, password: String): User? {
        // Mock registration - in real app, this would call API
        return if (fullName.isNotEmpty() && email.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()) {
            User("2", fullName, email, username)
        } else {
            null
        }
    }
    
    fun sendResetCode(email: String): Boolean {
        // Mock sending reset code - in real app, this would call API
        return email.isNotEmpty()
    }
    
    fun verifyResetCode(email: String, code: String): Boolean {
        // Mock verification - in real app, this would call API
        return code.length == 6
    }
    
    fun resetPassword(email: String, newPassword: String): Boolean {
        // Mock password reset - in real app, this would call API
        return newPassword.length >= 6
    }
}
