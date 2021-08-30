package com.example.cartaodevisitas.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cartaodevisitas.data.BusinessCard
import com.example.cartaodevisitas.data.BusinessCardRepository

class MainViewModel(private val cardRepository: BusinessCardRepository): ViewModel() {
    fun insert(businessCard: BusinessCard){
        cardRepository.insert(businessCard)
    }
    fun getAll() : LiveData<List<BusinessCard>>{
        return cardRepository.getAll()
    }
}

class MainViewModelFactory(private val repository: BusinessCardRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Uncknown ViewModel class")
    }
}