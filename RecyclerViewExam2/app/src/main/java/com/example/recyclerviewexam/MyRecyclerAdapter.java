package com.example.recyclerviewexam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<ViewHolder>{
    private final List<CardItem> mDataList;

    // 클릭 리스너
    public interface MyRecyclerViewClickListener{
        void onItemClicked(int position); // 클릭한 아이템 포지션
        void onShareButtonClicked(int position);
        void onLearnMoreButtonClicked(int position);
    }

    private  MyRecyclerViewClickListener mListener;

    public void setOnClickListener(MyRecyclerViewClickListener listener){
        mListener = listener;
    }

    public  MyRecyclerAdapter(List<CardItem> dataList){
        mDataList= dataList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        CardItem item = mDataList.get(position);
        holder.title.setText(item.getTitle());
        holder.contents.setText(item.getContents());

        //클릭이벤트
        if(mListener!=null){
            final int pos = position;
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClicked(pos);
                }
            });
            holder.share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onShareButtonClicked(pos);
                }
            });
            holder.more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onLearnMoreButtonClicked(pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }


}
