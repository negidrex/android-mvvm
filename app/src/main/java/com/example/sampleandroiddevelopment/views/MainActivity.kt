package com.example.sampleandroiddevelopment.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.example.sampleandroiddevelopment.R
import com.example.sampleandroiddevelopment.models.Quote
import com.example.sampleandroiddevelopment.utils.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.initializeUI()
    }

    private fun initializeUI(){
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this,factory).get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }

            textView.text = stringBuilder.toString()
        })

        button.setOnClickListener { it
            Log.i("Clicked", "This Clicked")
            val quote = Quote(editText.text.toString(), editText2.text.toString())
            viewModel.addQuote(quote)
            editText.setText("")
            editText2.setText("")
        }
    }
}
