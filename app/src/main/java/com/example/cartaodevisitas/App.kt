package com.example.cartaodevisitas

import android.app.Application
import com.example.cartaodevisitas.data.AppDatabase
import com.example.cartaodevisitas.data.BusinessCardRepository

class App: Application() {
    val database by lazy { AppDatabase.getDataBase(this) }
    val repository by lazy { BusinessCardRepository(database.busniseesDap())}
}