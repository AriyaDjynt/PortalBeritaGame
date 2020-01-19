package com.hendrysa.portalberitagame.ui.webview;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.hendrysa.portalberitagame.R;

public class Webview extends AppCompatActivity {

    String link;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        link = getIntent().getStringExtra("link");

        webView = findViewById(R.id.canvas_webview);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(link);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if(webView.canGoBack())
        {
            webView.goBack();
        }
        else
            {
                finish();
            }
    }
}
