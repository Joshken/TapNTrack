package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.model.UserRepository
import com.example.tapntrack.mvp.view.INewPasswordView

class NewPasswordPresenter(private val userRepository: UserRepository) : INewPasswordPresenter {
    
    private var view: INewPasswordView? = null
    
    override fun attachView(view: INewPasswordView) {
        this.view = view
    }
    
    override fun detachView() {
        this.view = null
    }
    
    override fun resetPassword(newPassword: String, confirmPassword: String) {
        view?.showProgress()
        
        // Validation
        if (newPassword.isEmpty()) {
            view?.showValidationError("newPassword", "New password is required")
            view?.hideProgress()
            return
        }
        
        if (newPassword.length < 6) {
            view?.showValidationError("newPassword", "Password must be at least 6 characters")
            view?.hideProgress()
            return
        }
        
        if (confirmPassword.isEmpty()) {
            view?.showValidationError("confirmPassword", "Please confirm your password")
            view?.hideProgress()
            return
        }
        
        if (newPassword != confirmPassword) {
            view?.showValidationError("confirmPassword", "Passwords do not match")
            view?.hideProgress()
            return
        }
        
        // Reset password (using a mock email for demo)
        val success = userRepository.resetPassword("user@example.com", newPassword)
        
        if (success) {
            view?.onPasswordResetSuccess()
            view?.navigateToPasswordChanged()
        } else {
            view?.onPasswordResetFailed("Failed to reset password")
        }
        
        view?.hideProgress()
    }
    
    override fun onBackClicked() {
        view?.navigateBack()
    }
}
