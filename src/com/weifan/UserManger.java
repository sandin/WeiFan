package com.weifan;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

import com.weibo.sdk.android.Oauth2AccessToken;

public class UserManger {
    private static SharedPreferences mAppPref;

    public static boolean isLogined(Context context) {
        ensurePref(context);
        return isValid(getUser(context));
    }
    
    private static SharedPreferences ensurePref(Context context) {
        if (mAppPref == null) {
            mAppPref = context.getSharedPreferences("weifan", Context.MODE_PRIVATE);
        }
        return mAppPref;
    }
    
    public static boolean login(Context context, String user, Oauth2AccessToken accessToken) {
        if (! TextUtils.isEmpty(user)) {
            ensurePref(context);
            Editor editor = mAppPref.edit();
            editor.putString("user", user);
            editor.putString("access_token", accessToken.getToken());
            editor.putLong("expires_in", accessToken.getExpiresTime());
            editor.commit();
            return true;
        }
        return false;
    }
    
    public static void logout(Context context) {
        ensurePref(context);
        Editor editor = mAppPref.edit();
        editor.remove("user");
        editor.remove("access_token");
        editor.remove("expires_in");
        editor.commit();
    }
    
    public static User getUser(Context context) {
        ensurePref(context);
        User user = new User();
        user.uid = mAppPref.getString("user", null);
        user.access_token = mAppPref.getString("access_token", null);
        user.expires_in = mAppPref.getLong("expires_in", -1);
        
        return user;
    }
    
    public static boolean isValid(User user) {
        return user != null
                && user.uid != null
                && user.access_token != null
                && user.expires_in != -1;
    }
    
    public static class User {
        public String uid;
        public String access_token;
        public long expires_in;
    }

}
