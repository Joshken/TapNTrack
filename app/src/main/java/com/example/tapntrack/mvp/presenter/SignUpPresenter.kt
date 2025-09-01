package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.model.UserRepository
import com.example.tapntrack.mvp.view.ISignUpView
import android.util.Patterns

class SignUpPresenter(private val userRepository: UserRepository) : ISignUpPresenter {
    
    private var view: ISignUpView? = null
    
    override fun attachView(view: ISignUpView) {
        this.view = view
    }
    
    override fun detachView() {
        this.view = null
    }
    
    override fun signUp(fullName: String, email: String, username: String, password: String, confirmPassword: String) {
        view?.showProgress()
        
        // Validation
        if (fullName.isEmpty()) {
            view?.showValidationError("fullName", "Full name is required")
            view?.hideProgress()
            return
        }
        
        if (email.isEmpty()) {
            view?.showValidationError("email", "Email is required")
            view?.hideProgress()
            return
        }
        
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            view?.showValidationError("email", "Please enter a valid email address")
            view?.hideProgress()
            return
        }
        
        if (username.isEmpty()) {
            view?.showValidationError("username", "Username is required")
            view?.hideProgress()
            return
        }
        
        if (username.length < 3) {
            view?.showValidationError("username", "Username must be at least 3 characters")
            view?.hideProgress()
            return
        }
        
        if (password.isEmpty()) {
            view?.showValidationError("password", "Password is required")
            view?.hideProgress()
            return
        }
        
        if (password.length < 6) {
            view?.showValidationError("password", "Password must be at least 6 characters")
            view?.hideProgress()
            return
        }
        
        if (confirmPassword.isEmpty()) {
            view?.showValidationError("confirmPassword", "Please confirm your password")
            view?.hideProgress()
            return
        }
        
        if (password != confirmPassword) {
            view?.showValidationError("confirmPassword", "Passwords do not match")
            view?.hideProgress()
            return
        }
        
        // Register user
        val user = userRepository.registerUser(fullName, email, username, password)
        
        if (user != null) {
            view?.onSignUpSuccess(user)
            view?.navigateToDashboard()
        } else {
            view?.onSignUpFailed("Registration failed")
        }
        
        view?.hideProgress()
    }
    
    override fun onBackClicked() {
        view?.navigateBack()
    }
}
