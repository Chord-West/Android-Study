package com.example.callbackexam;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.Arrays;
import java.util.List;

public class ColorListFragment extends ListFragment {

    private OnColorSelectedListener mListener;

    interface OnColorSelectedListener{
        void onColorSelected(int color);
    }

    @Override
    public void onAttach(Context context){ // 프래그먼트에서 자주사용
        super.onAttach(context);
        try{
            mListener=(OnColorSelectedListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(((Activity) context).getLocalClassName()+" 는 OnColorSelectedListener를 구현해야 합니다");
        }

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<String> colorList = Arrays.asList("Red","Green","Blue");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,colorList);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) getListAdapter(); //현재 리스트 어댑터를 불러온다
        String colorString = adapter.getItem(position);
        int color = Color.RED;

        switch (colorString){
            case "Red":
                color=Color.RED;
                break;
            case "Green":
                color=Color.GREEN;
                break;
            case "Blue":
                color=Color.BLUE;
                break;
        }
        if(mListener!=null){
            mListener.onColorSelected(color);
        }
    }
}
