package com.dabu.firebase.common;

import com.dabu.firebase.service.FireBase;
import com.google.firebase.iid.FirebaseInstanceId;

import java.io.IOException;

public class FireBaseUntil {
    private static String token = null;

    /**
     * 获取fireBase令牌
     */
    public static void useFireBaseToken(final FireBase fireBase) {
        /**
         * 下面这段代码是为了减少请求次数，重用token
         */
        if (token != null)
            fireBase.userTokens(token);
        else {
            FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(task -> {
                if (!task.isSuccessful()) {
                    return;
                }
                // Get new Instance ID token
                token = task.getResult().getToken();
                fireBase.userTokens(token);
            });
        }
    }

    /**
     * 删除fireBase实例
     */
    public void deleteFireBaseInstanceId() {
        new Thread(() -> {
            try {
                FirebaseInstanceId.getInstance().deleteInstanceId();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}


