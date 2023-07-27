package com.example.mvi_basic

class StringFormatter {
    companion object {
        fun formatUserList(userEntityList: List<UserEntity?>?): String {
            return userEntityList?.joinToString("\n") { user ->
                user?.let { "${it.name}, ID: ${it.id}" }.toString()
            } ?: ""
        }
    }
}
