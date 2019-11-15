package com.dabu.firebase.service;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MyFirebaseMessagingService extends FirebaseMessagingService {

    /**
     * 当token更新的时候调用这个方法
     *
     * @param s
     */
    @Override
    public void onNewToken(String s) {
        Log.e("TOKEN", "onNewToken: " + s);
    }

    /**
     * 接收到通知后，会进行这个方法的调用
     *
     * @param remoteMessage
     */
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.e("MESSAGE", "onMessageReceived: " + "接受到信息啦");
    }
}
