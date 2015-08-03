package com.verys.saumiljobalia.androidmpermissions;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

/**
 * Created by saumiljobalia on 8/3/15.
 */
public abstract class RuntimePermission {


    public static boolean verifyPermissions(int[] getResults){
        for (int result : getResults){
            if (result != PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }

    public static boolean hasSelfPermission(Activity activity, String[] permissions){
        if (!isMNC()){
            return true;
        }

        for (String permission : permissions){
            if (activity.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }

        return true;
    }

    public static boolean hasSelfPermission(Activity activity, String permissions){
        if (!isMNC()){
            return true;
        }

        return activity.checkSelfPermission(permissions) == PackageManager.PERMISSION_GRANTED;
    }

    private static boolean isMNC() {
        return "MNC".equals(Build.VERSION.CODENAME);
    }
}
