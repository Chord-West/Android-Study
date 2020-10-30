package com.example.recyclerviewexam;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder{
    TextView title;
    TextView contents;
    Button share;
    Button more;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title_text);
        contents= itemView.findViewById(R.id.contents_text);
        share=itemView.findViewById(R.id.share_button);
        more = itemView.findViewById(R.id.more_button);
    }
}