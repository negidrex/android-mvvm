package com.example.sampleandroiddevelopment.utils

import com.example.sampleandroiddevelopment.models.FakeDatabase
import com.example.sampleandroiddevelopment.models.QuoteRepository
import com.example.sampleandroiddevelopment.views.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory() : QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}