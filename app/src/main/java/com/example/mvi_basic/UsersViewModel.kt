package com.example.mvi_basic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// MVI ViewModel
class UsersViewModel : ViewModel() {
    private val _state: MutableLiveData<UsersModel> = MutableLiveData()

    val state: LiveData<UsersModel>
        get() = _state

    init {
        _state.value = UsersModel(emptyList())
    }

    fun handleIntent(intent: UsersIntent) {
        when (intent) {
            is UsersIntent.LoadUsers -> loadUsers()
            is UsersIntent.LoadUser -> loadUser(intent.id)
        }
    }

    private fun loadUsers() {
        val listOfUsers = listOf(
            UserEntity(1, "Uddhav Gautam"),
            UserEntity(2, "Rose Gautam")
        )
        _state.value = UsersModel(listOfUsers)
    }

    private fun loadUser(id: Int) {
        val listOfUsers = listOf(
            UserEntity(1, "Uddhav Gautam"),
            UserEntity(2, "Rose Gautam")
        )
        val listOfUsersToReturn = listOf(listOfUsers[id])
        _state.value = UsersModel(listOfUsersToReturn)
    }
}
