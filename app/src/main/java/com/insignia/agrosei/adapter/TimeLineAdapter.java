package com.insignia.agrosei.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.insignia.agrosei.R;
import com.insignia.agrosei.activity.ChatBot;
import com.insignia.agrosei.activity.NewsActivity;
import com.insignia.agrosei.model.MoreModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.ViewHolder> {

    public ArrayList<?> Data;
    Context context;

    public TimeLineAdapter(Context context, ArrayList<?> data) {
        Data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.timeline_card,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.heading.setText(Data.get(position).getHeading());
//        holder.subheading.setText(Data.get(position).getSub());
//        Picasso.get().load(Data.get(position).getImgUrl()).fit().into(holder.img);
//
    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView heading,subheading,time;
        VideoView video;
        CardView card;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//             heading =itemView.findViewById(R.id.head_card);
//             subheading = itemView.findViewById(R.id.txt_card);
//             img=itemView.findViewById(R.id.img_card);
//             card = itemView.findViewById(R.id.moreCard);
        }
    }
}
