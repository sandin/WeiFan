package com.weifan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

import com.slidingmenu.lib.SlidingMenu;

public class FlyInMenu {

    public static void setUpMenu(final Context context, SlidingMenu menu) {
        
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);

        ListView menuList = (ListView) menu.findViewById(R.id.menu_list);
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", "首页");
        data.add(map);
        map = new HashMap<String, Object>();
        map.put("name", "个人中心");
        data.add(map);

        menuList.setAdapter(new SimpleAdapter(context, data,
                R.layout.menu_item, new String[] { "name" },
                new int[] { R.id.menu_title }));
        menuList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                    long arg3) {
                context.startActivity(new Intent(context, MainActivity.class));
            }
        });

    }

}
