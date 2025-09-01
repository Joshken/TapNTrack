package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.model.UserRepository
import com.example.tapntrack.mvp.view.IForgotPasswordView
import android.util.Patterns

class ForgotPasswordPresenter(private val userRepository: UserRepository) : IForgotPasswordPresenter {
    
    private var view: IForgotPasswordView? = null
    
    override fun attachView(view: IForgotPasswordView) {
        this.view = view
    }
    
    override fun detachView() {
        this.view = null
    }
    
    override fun sendResetCode(email: String) {
        view?.showProgress()
        
        // Validation
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
        
        // Send reset code
        val success = userRepository.sendResetCode(email)
        
        if (success) {
            view?.onResetCodeSent(email)
            view?.navigateToSentOtp(email)
        } else {
            view?.onResetCodeFailed("Failed to send reset code")
        }
        
        view?.hideProgress()
    }
    
    override fun onBackClicked() {
        view?.navigateBack()
    }
}
