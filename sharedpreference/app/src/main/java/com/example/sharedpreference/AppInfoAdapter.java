package com.example.sharedpreference;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AppInfoAdapter extends BaseAdapter {
    private List<ApplicationInfo> mInfos;

    public AppInfoAdapter(List<ApplicationInfo> data) {
        this.mInfos = data;
    }

    @Override
    public int getCount() {
        return mInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return mInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder=new ViewHolder(); //최초에 생성되는 것이면 ViewHolder를 생성
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app,parent,false);
            holder.imageView = convertView.findViewById(R.id.icon_image);
            holder.textView = convertView.findViewById(R.id.app_name_text);
            convertView.setTag(holder); // holder와 convert view 연결
        }else{ //재사용할 때
            holder = (ViewHolder) convertView.getTag();
        }
        ApplicationInfo info = mInfos.get(position); // postion의 객체
        Drawable icon = info.loadIcon(parent.getContext().getPackageManager()); // info안에서 Drawable (아이콘) 을 얻을 수 있음
        holder.imageView.setImageDrawable(icon);

        String name = String.valueOf(info.loadLabel(parent.getContext().getPackageManager()));
        holder.textView.setText(name);

        return convertView;
    }

    private static class ViewHolder //내부클래스는 static으로 만들어야 메모리누수(leak)를 안발생시킴
    {
        ImageView imageView;
        TextView textView;
    }
}
