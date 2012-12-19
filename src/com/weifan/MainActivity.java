package com.weifan;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Callable;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.alibaba.fastjson.JSON;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingListActivity;
import com.weibo.sdk.android.WeiboException;
import com.weibo.sdk.android.api.StatusesAPI;
import com.weibo.sdk.android.api.WeiboAPI;
import com.weibo.sdk.android.net.RequestListener;
import com.weifan.adapter.StatusAdapter;
import com.weifan.db.DatabaseHelper;
import com.weifan.model.Status;
import com.weifan.model.User;
import com.weifan.weibo.Statuses;
import com.weifan.weibo.WeiboFactory;

public class MainActivity extends SlidingListActivity {
    private SlidingMenu menu;
    private ActionBar actionBar;
    
    private ListView listView;
    private StatusAdapter listAdapter;
    private DatabaseHelper dbHelper;
    
    private List<Status> list;
    private Dao<Status, Integer> statusDao;
    private Dao<User, Integer> userDao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (! UserManger.isLogined(this)) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }
        
        setContentView(R.layout.activity_main);
        setBehindContentView(R.layout.fragement_menu); 
        
        menu = getSlidingMenu();
        FlyInMenu.setUpMenu(this, menu);
        
        setUpDatabase();
        setUpActionBar();
        setUpViews();
        onRefresh();
    }

    private void setUpDatabase() {
        dbHelper = new DatabaseHelper(this);
        try {
            statusDao = dbHelper.getDao(Status.class);
            userDao = dbHelper.getDao(User.class);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void setUpViews() {
        listView = getListView();
        listAdapter = new StatusAdapter(this);
        listView.setAdapter(listAdapter);
    }

    private void onRefresh() {
        System.out.println("onRefresh");
        
        try {
            list = statusDao.queryForAll();
            for (Status s : list) {
                userDao.refresh(s.getUser());
            }
            listAdapter.refresh(list);
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
    }
    
    private void refresh() {
        StatusesAPI api = new StatusesAPI(WeiboFactory.getWeibo(this).accessToken);
//      api.homeTimeline(since_id, max_id, count, page, base_app, feature, trim_user, listener)
        api.homeTimeline(0, 0, 20, 1, false, WeiboAPI.FEATURE.ALL, true, new RequestListener() {
          
          @Override
          public void onIOException(IOException e) {
              e.printStackTrace();
          }
          
          @Override
          public void onError(WeiboException e) {
              System.out.println("onError");
              e.printStackTrace();
          }
          
          @Override
          public void onComplete(String res) {
              System.out.println("onComplete: " + res);
              
              if (! TextUtils.isEmpty(res)) {
                  Statuses statues = JSON.parseObject(res, Statuses.class);
                  
                  saveStatusesIntoDb(statues.getStatuses());
                  
                  runOnUiThread(new Runnable() {
                    public void run() {
                        onRefresh();
                    }
                  });
              }
          }

      });
        
    }
    
    private void saveStatusesIntoDb(final List<Status> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        if (statusDao == null) {
            // TODO: Log.e(TAG, "statusDao = null");
            return;
        }
        
        // 事务批量插入
        try {
            TransactionManager.callInTransaction(dbHelper.getConnectionSource(), new Callable<Void>() {
                    public Void call() throws Exception {
                        // DELETE ALL OLD
                        DeleteBuilder<Status, Integer> query = statusDao.deleteBuilder();
                        query.delete();
                        
                        // INSERT ALL NEW
                        for (Status s : list) {
                            statusDao.create(s);
                        }
                        return null;
                    }
            });
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
           
    }

    private void setUpActionBar() {
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                System.out.println("click home");
                menu.showBehind();
                return true;
            case R.id.menu_refresh:
                refresh();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
