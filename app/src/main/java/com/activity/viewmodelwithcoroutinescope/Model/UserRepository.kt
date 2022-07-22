package com.activity.viewmodelwithcoroutinescope.Model

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUser() : List<User>{
        delay(8000)
        val users: List<User> = listOf(
            User(1,"Alex"),
            User(2,"Kyla"),
            User(3,"Noel"),
            User(4,"Lyla"),
            User(5,"Joel"),
        )
        return users
    }
}