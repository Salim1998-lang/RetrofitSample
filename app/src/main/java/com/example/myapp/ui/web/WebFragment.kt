package com.example.myapp.ui.web

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapp.databinding.FragmentWebBinding

class WebFragment : Fragment() {

    private lateinit var webViewModel: WebViewModel
    private var _binding: FragmentWebBinding? = null
    private lateinit var webView: WebView
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        webViewModel = ViewModelProvider(this).get(WebViewModel::class.java)
        _binding = FragmentWebBinding.inflate(inflater, container, false)
        setupWebView()
        onBack()
        val root: View = binding.root
        return root
    }

    private fun setupWebView() {
        webView = binding.webView
        webView.webViewClient = WebViewClient()
        webView.apply {
            loadUrl("http://www.icndb.com/api/")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
    }

    private fun onBack() {
        webView.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                    webView.goBack()
                    return true
                }
                return false
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}