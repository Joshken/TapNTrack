package com.example.tapntrack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tapntrack.mvp.model.AttendanceRepository
import com.example.tapntrack.mvp.presenter.IManageUsersPresenter
import com.example.tapntrack.mvp.presenter.ManageUsersPresenter
import com.example.tapntrack.mvp.view.IManageUsersView

class ActivityManageUsers : AppCompatActivity(), IManageUsersView {

    private lateinit var presenter: IManageUsersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_users)

        // Initialize presenter
        presenter = ManageUsersPresenter(AttendanceRepository())
        presenter.attachView(this)

        // Load users
        presenter.loadUsers()
    }

    override fun showProgress() {
        // Show loading indicator if needed
    }

    override fun hideProgress() {
        // Hide loading indicator if needed
    }

    override fun displayUsers(users: List<com.example.tapntrack.mvp.model.User>) {
        // In a real app, you would populate a RecyclerView with the users
        // For now, we'll just show a count
        // This would be implemented with an adapter
    }

    override fun onUsersLoadFailed(message: String) {
        // Handle error - could show a toast or error message
    }

    override fun navigateToDashboard() {
        val intent = Intent(this, ActivityDashboard::class.java)
        startActivity(intent)
    }

    override fun navigateToLogs() {
        val intent = Intent(this, ActivityLogs::class.java)
        startActivity(intent)
    }

    override fun navigateToSettings() {
        val intent = Intent(this, ActivitySettings::class.java)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
