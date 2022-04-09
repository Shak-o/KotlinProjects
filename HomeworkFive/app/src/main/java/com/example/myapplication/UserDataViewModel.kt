package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.room.Room
import persistence.AppDatabase
import persistence.UserData

class UserDataViewModel : ViewModel() {

    fun saveData(db:Room, userData: UserData){

    }
}