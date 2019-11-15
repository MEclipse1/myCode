package com.dabu.firebase;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

import com.dabu.firebase.common.FireBaseUntil;
import com.dabu.firebase.control.webView.MyWebViewClient;

public class MainActivity extends FragmentActivity {
    private static final String TAG = "MainActivity";

    private WebView webView;
    private TextView textView;

    private MyWebViewClient viewClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView2);

        //给TextView赋fireBase token的值
        FireBaseUntil.useFireBaseToken(token -> textView.setText(token));

        //打印 fireBase token log
        FireBaseUntil.useFireBaseToken(token -> Log.e(TAG, "onCreate: " + token));

//        viewClient = new MyWebViewClient();
//        webView = findViewById(R.id.webView);
//        webView.setWebViewClient(viewClient);
//        webView.loadUrl("https://www.baidu.com");
    }
}
