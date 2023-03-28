package com.aryan.vault

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.annotation.RequiresApi

class PdfShowAct : AppCompatActivity() {

    lateinit var wb_webView: WebView
    lateinit var progressBar: ProgressBar

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_show)
        val url: String? = intent.getStringExtra("URL").toString()
        if (url != null) {

            // wb_webView= findViewById(R.id.wb_webView)
            wb_webView.settings.javaScriptEnabled = true

            wb_webView.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    progressBar.visibility = View.GONE
                    wb_webView.visibility = View.VISIBLE

                }
            }
            wb_webView.loadUrl(url)


        }
    }
}
/*@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("SetJavaScriptEnabled")
    private fun webViewSetup() {
    wb_webView= findViewById(R.id.wb_webView)
    wb_webView.webViewClient = WebViewClient()
    val b:Bundle = intent.extras!!
    val url = b.getString("url")!!
        wb_webView.apply{
            url?.let { loadUrl(it) }
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }


    }
*/