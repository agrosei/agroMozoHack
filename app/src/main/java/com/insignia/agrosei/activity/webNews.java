package com.insignia.agrosei.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.insignia.agrosei.R;

public class webNews extends AppCompatActivity {
    WebView webViewform;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_news);
        webViewform = findViewById(R.id.web);
        Intent intent = getIntent();
        url = intent.getStringExtra("link");



        webViewform.setWebViewClient(new MyBrowser());

        webViewform.getSettings().setLoadsImagesAutomatically(true);
        webViewform.getSettings().setJavaScriptEnabled(true);
        webViewform.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webViewform.loadUrl(url);

    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}