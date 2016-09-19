package com.benrawlins.researchgenius;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView rgWebView = (WebView)findViewById(R.id.myWebView);
        rgWebView.getSettings().setJavaScriptEnabled(true);
        rgWebView.setWebViewClient(new WebViewClient());
        rgWebView.loadUrl("http://libguides.georgetowncollege.edu/RG");

        rgWebView.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                super.onPageStarted(view, url, favicon);
                findViewById(R.id.progressBarGC).setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                findViewById(R.id.progressBarGC).setVisibility(View.GONE);
            }
        });
    }
}
