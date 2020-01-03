package com.dabu.firebase.common;

import android.content.Context;
import android.content.pm.PackageManager;

public class Until {
    /**
     * 获取当前本地apk的版本
     *
     * @param mContext
     * @return
     */
    private int getVersionCode(Context mContext) {
        int versionCode = 0;

        try {
            versionCode = (int) mContext.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(mContext.getPackageName(), 0)
                    .versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }
}
