package com.weifan.weibo;

import android.content.Context;

import com.weibo.sdk.android.Oauth2AccessToken;
import com.weibo.sdk.android.Weibo;
import com.weifan.Configs;
import com.weifan.UserManger;

public class WeiboFactory {
    
    public static Weibo getWeibo(Context context) {
        Weibo weibo = Weibo.getInstance(Configs.WEIBO_KEY, Configs.WEIBO_REDIRECT_URL);
        // insert accessToken from cache
        UserManger.User user = UserManger.getUser(context);
        if (user != null) {
            weibo.accessToken = new Oauth2AccessToken(user.access_token, user.expires_in+"");
        }
        return weibo;
    }
    
}
