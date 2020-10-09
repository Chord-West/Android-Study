package com.example.adapterviewexam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFirstAdapter extends BaseAdapter {
    private List<Weather> mData;
    private Map<String,Integer> mWeatherImageMap;

    public MyFirstAdapter(List<Weather> data){
        this.mData=data;
        mWeatherImageMap = new HashMap<>();
        mWeatherImageMap.put("맑음", R.drawable.ic_launcher_background);
        mWeatherImageMap.put("폭설", R.drawable.ic_launcher_background);
        mWeatherImageMap.put("구름", R.drawable.ic_launcher_background);
        mWeatherImageMap.put("비", R.drawable.ic_launcher_background);
        mWeatherImageMap.put("눈", R.drawable.ic_launcher_background);
}

    @Override
    public int getCount() {
        return mData.size(); // 데이터의 사이즈를 알려줌
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position); //몇번째에 아이템이 있는지
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override // 중요
    public View getView(int position, View convertView, ViewGroup parent) {
        // 성능이 안좋은 코드  생성할때마다 infalte를 쓰면 cpu성능을 많이 잡아먹음,
        //convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather,parent,false);
//        ImageView weatherImage = convertView.findViewById(R.id.weather_image);
//        TextView cityText = convertView.findViewById(R.id.city_text);
//        TextView tempText = convertView.findViewById(R.id.temp_text);
        // 기존의 것을 재상용하게 만들기
        ViewHolder holder;
        if(convertView ==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather,parent,false);
            ImageView weatherImage = convertView.findViewById(R.id.weather_image);
            TextView cityText = convertView.findViewById(R.id.city_text);
            TextView tempText = convertView.findViewById(R.id.temp_text);

            holder.weatherImage=weatherImage;
            holder.cityText=cityText;
            holder.tempText=tempText;
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag(); // 재사용할때는 가지고만 오기
        }


        Weather weather = mData.get(position);
        holder.cityText.setText(weather.getCity());
        holder.tempText.setText(weather.getTemp());
        holder.weatherImage.setImageResource(mWeatherImageMap.get(weather.getWeather()));

        return convertView;
        //레이아웃을 들고와서 각각 표시될 때 마다 호출 , view를 리턴
    }
    static class ViewHolder{
        ImageView weatherImage;
        TextView cityText;
        TextView tempText;
    }
}
