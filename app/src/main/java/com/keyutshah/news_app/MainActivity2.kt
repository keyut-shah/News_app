package com.keyutshah.news_app

import android.os.Bundle
import android.os.PersistableBundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main2)

        webView=findViewById(R.id.web_view)

        val url = intent.data
        webView.loadUrl(url.toString())

    }

}