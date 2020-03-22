package com.example.sampleandroiddevelopment.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {
    private val quoteList = mutableListOf<Quote>()
    private val qoutes = MutableLiveData<List<Quote>>()

    init {
        qoutes.value = quoteList
    }

    fun addQuote(quote: Quote) {
        this.quoteList.add(quote)
        this.qoutes.value = quoteList
    }

    fun getQuotes() = qoutes as LiveData<List<Quote>>
}