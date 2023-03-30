package com.aryan.vault

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.RequiresApi

class PdfShowAct : AppCompatActivity() {

    var mwb_webView: WebView? = null
    var mprogressBar: ProgressBar? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_show)
        mwb_webView = findViewById<View>(R.id.wb_webView) as WebView
        mprogressBar = findViewById(R.id.progressBar)
        val url: String? = intent.getStringExtra("URL")
        if (url != null) {
Toast.makeText(this,"$url",Toast.LENGTH_LONG).show()
            // wb_webView= findViewById(R.id.wb_webView)
            mwb_webView!!.settings.javaScriptEnabled = true
            mwb_webView!!.settings.safeBrowsingEnabled = true

            mwb_webView!!.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    mprogressBar!!.visibility = View.GONE
                    mwb_webView!!.visibility = View.VISIBLE

                }
            }
            mwb_webView!!.loadUrl("$url")

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