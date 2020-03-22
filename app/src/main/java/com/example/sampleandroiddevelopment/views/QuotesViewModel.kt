package com.example.sampleandroiddevelopment.views

import androidx.lifecycle.ViewModel
import com.example.sampleandroiddevelopment.models.Quote
import com.example.sampleandroiddevelopment.models.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()
    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}