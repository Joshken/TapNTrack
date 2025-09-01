package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.model.UserRepository
import com.example.tapntrack.mvp.view.IEnterOtpView

class EnterOtpPresenter(private val userRepository: UserRepository) : IEnterOtpPresenter {
    
    private var view: IEnterOtpView? = null
    
    override fun attachView(view: IEnterOtpView) {
        this.view = view
    }
    
    override fun detachView() {
        this.view = null
    }
    
    override fun verifyOtp(email: String, otp: String) {
        view?.showProgress()
        
        // Validation
        if (otp.isEmpty()) {
            view?.showValidationError("otp", "Please enter the reset code")
            view?.hideProgress()
            return
        }
        
        if (otp.length != 6) {
            view?.showValidationError("otp", "Please enter a 6-digit code")
            view?.hideProgress()
            return
        }
        
        // Verify OTP
        val success = userRepository.verifyResetCode(email, otp)
        
        if (success) {
            view?.onOtpVerified(email)
            view?.navigateToNewPassword(email)
        } else {
            view?.onOtpVerificationFailed("Invalid reset code")
        }
        
        view?.hideProgress()
    }
    
    override fun resendCode(email: String) {
        val success = userRepository.sendResetCode(email)
        
        if (success) {
            view?.onResendCodeSuccess(email)
        } else {
            view?.onResendCodeFailed("Failed to resend code")
        }
    }
    
    override fun onBackClicked() {
        view?.navigateBack()
    }
}
