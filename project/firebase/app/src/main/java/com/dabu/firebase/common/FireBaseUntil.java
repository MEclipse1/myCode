package com.dabu.firebase.common;

import android.support.annotation.NonNull;

import com.dabu.firebase.service.FireBase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.io.IOException;

public class FireBaseUntil {
    /**
     * 获取fireBase令牌
     */
    public static void useFireBaseToken(final FireBase fireBase) {
        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                if (!task.isSuccessful()) {
                    return;
                }
                // Get new Instance ID token
                fireBase.userTokens(task.getResult().getToken());
            }
        });
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


