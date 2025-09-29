package com.fera.menus

import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment

class FragmentoAds : Fragment(R.layout.fragmento_ads) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView : WebView = view.findViewById(R.id.webview_video)
        val settings : WebSettings = webView.settings
        settings.javaScriptEnabled = true

        webView.webViewClient = WebViewClient()
        val html = """
            <iframe width = "100%" height = "100%"
            src = "https://www.youtube.com/watch?v=aCZqrWOLFns"
            frameborder = "0" allowfullscreen>
            
            </iframe>
        """.trimIndent()
        webView.loadData(html, "text/html", "utf-8")
    }
}