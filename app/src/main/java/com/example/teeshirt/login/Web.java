package com.example.teeshirt.login;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class Web extends ActionBarActivity{

    private static Button button;
    private static EditText editText;
    private static WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        openUrl();
    }

    public void openUrl(){
        button = (Button)findViewById(R.id.btn);
        editText = (EditText)findViewById(R.id.et);
        webView = (WebView)findViewById(R.id.webview);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = editText.getText().toString();
                        webView.getSettings().setLoadsImagesAutomatically(true);
                        webView.getSettings().setJavaScriptEnabled(true);
                        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                        webView.loadUrl(url);
                    }
                }
        );
    }
}
