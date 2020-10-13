package com.example.personalassignment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.personalassignment.R;
import com.example.personalassignment.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductAdapter extends BaseAdapter {
    private List<Product> mData;
    private Map<String,Integer> mProductImageMap;

    public ProductAdapter(List<Product> data){
        this.mData=data;
        mProductImageMap = new HashMap<>();
        mProductImageMap.put("outer", R.drawable.outer);
        mProductImageMap.put("top",R.drawable.top);
        mProductImageMap.put("bottom",R.drawable.bottom);
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override

    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
            ImageView productImage = convertView.findViewById(R.id.product_image);
            TextView productTitle= convertView.findViewById(R.id.product_title);
            TextView productPrice= convertView.findViewById(R.id.product_price);
            CheckBox checkBox = convertView.findViewById(R.id.checkBox);
            holder.productImage=productImage;
            holder.productTitle=productTitle;
            holder.productPrice= productPrice;
            holder.checkBox=checkBox;
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Product product = mData.get(position);
        holder.productTitle.setText(product.getTitle());
        holder.productPrice.setText(product.getPrice());
        holder.productImage.setImageResource(mProductImageMap.get(product.getCategory()));
        holder.checkBox.setChecked(product.isCheck());
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean newState = !mData.get(position).isCheck();
                mData.get(position).setCheck(newState);
                System.out.println(newState);
            }
        });
        return convertView;
    }
    static class ViewHolder{
        ImageView productImage;
        TextView productTitle;
        TextView productPrice;
        CheckBox checkBox;
    }
}
