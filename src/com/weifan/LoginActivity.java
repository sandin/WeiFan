package com.weifan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockActivity;
import com.weibo.sdk.android.Oauth2AccessToken;
import com.weibo.sdk.android.Weibo;
import com.weibo.sdk.android.WeiboAuthListener;
import com.weibo.sdk.android.WeiboDialogError;
import com.weibo.sdk.android.WeiboException;
import com.weifan.weibo.WeiboFactory;

public class LoginActivity extends SherlockActivity implements OnClickListener {
    private Button loginBtn;
    
    private Weibo weibo;
    private SharedPreferences mAppPref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        initViews();
        
        weibo = WeiboFactory.getWeibo(this);
    }

    private void initViews() {
        loginBtn = (Button) findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.login_btn:
            weibo.authorize(this, new AutoListener());
            break;
        default:
            break;
        }

    }

    private class AutoListener implements WeiboAuthListener {

        @Override
        public void onCancel() {
            // TODO Auto-generated method stub

        }

        @Override
        public void onComplete(Bundle values) {
            System.out.println("onComplete: " + values);
            String token = values.getString("access_token");
            String expires_in = values.getString("expires_in");
            String uid = values.getString("uid", null);
            
            Oauth2AccessToken accessToken = new Oauth2AccessToken(token, expires_in);
            if (accessToken.isSessionValid()) {
                UserManger.login(LoginActivity.this, uid, accessToken);
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }
        }

        @Override
        public void onError(WeiboDialogError arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onWeiboException(WeiboException arg0) {
            // TODO Auto-generated method stub

        }
    }

}
