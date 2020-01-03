package com.dabu.firebase.control.webView;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {

    /**
     * 安卓高版本需要https的认证，
     * 当证书认证错误时候会调用这个方法
     *
     * 更改系统时间会导致证书认证错误，
     * 从而调用这个方法
     * @param view
     * @param handler
     * @param error
     */
    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        super.onReceivedSslError(view, handler, error);
    }
}
