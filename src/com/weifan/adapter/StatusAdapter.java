package com.weifan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edroid.widget.BaseListAdapter;
import com.weifan.R;
import com.weifan.model.Status;

public class StatusAdapter extends BaseListAdapter<Status> {

    public StatusAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;
        if (convertView == null) {
            view = mInflater.inflate(R.layout.status_item, null);
            holder = new ViewHolder();
            holder.content = (TextView) view.findViewById(R.id.status_item_content);
            holder.user = (TextView) view.findViewById(R.id.status_item_user);
            holder.date = (TextView) view.findViewById(R.id.status_item_date);
            view.setTag(holder);
        } else {
            view = convertView;
        }
        
        holder = (ViewHolder) view.getTag();
        Status bean = list.get(position);
        if (bean != null) {
            System.out.println("bean : " + bean);
            holder.content.setText(bean.getText());
            if (bean.getUser() != null) {
                holder.user.setText(bean.getUser().getScreen_name());
            }
            holder.date.setText(bean.getCreated_at());
        }
        
        return view;
    }

    
    class ViewHolder {
        TextView content;
        TextView user;
        TextView date;
    }

}
