package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.model.UserRepository
import com.example.tapntrack.mvp.view.ILoginView
import android.util.Patterns

class LoginPresenter(private val userRepository: UserRepository) : ILoginPresenter {
    
    private var view: ILoginView? = null
    
    override fun attachView(view: ILoginView) {
        this.view = view
    }
    
    override fun detachView() {
        this.view = null
    }
    
    override fun login(username: String, password: String) {
        view?.showProgress()
        
        // Validation
        if (username.isEmpty()) {
            view?.showValidationError("username", "Username is required")
            view?.hideProgress()
            return
        }
        
        if (password.isEmpty()) {
            view?.showValidationError("password", "Password is required")
            view?.hideProgress()
            return
        }
        
        // Authenticate user
        val user = userRepository.authenticate(username, password)
        
        if (user != null) {
            view?.onLoginSuccess(user)
            view?.navigateToDashboard()
        } else {
            view?.onLoginFailed("Invalid credentials")
        }
        
        view?.hideProgress()
    }
    
    override fun onSignUpClicked() {
        view?.navigateToSignUp()
    }
    
    override fun onForgotPasswordClicked() {
        view?.navigateToForgotPassword()
    }
}
