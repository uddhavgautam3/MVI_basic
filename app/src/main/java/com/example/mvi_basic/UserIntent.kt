package com.example.mvi_basic

// MVI Intent, which defines intent (action) to perform
sealed class UsersIntent {
    data class LoadUser(val id: Int) : UsersIntent()
    object LoadUsers : UsersIntent()
}
