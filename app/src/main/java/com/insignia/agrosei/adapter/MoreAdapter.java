package com.insignia.agrosei.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.insignia.agrosei.CropDetect.DetectCrop;
import com.insignia.agrosei.R;
import com.insignia.agrosei.activity.ChatBot;
import com.insignia.agrosei.activity.NewsActivity;
import com.insignia.agrosei.activity.SingleNewsActivity;
import com.insignia.agrosei.model.MoreModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class MoreAdapter extends RecyclerView.Adapter<MoreAdapter.ViewHolder> {

    public ArrayList<MoreModel> Data;
    Context context;

    public MoreAdapter(Context context, ArrayList<MoreModel> data) {
        Data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.more_card,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.heading.setText(Data.get(position).getHeading());
        holder.subheading.setText(Data.get(position).getSub());
        Picasso.get().load(Data.get(position).getImgUrl()).fit().into(holder.img);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(position == 1)
                {
                     Intent i;
                     i = new Intent(context, NewsActivity.class);
                    context.startActivity(i);

                }
                if(position==2)
                {
                    Intent i;
                    i = new Intent(context, ChatBot.class);
                    context.startActivity(i);
                }
                if(position==3)
                {
                    Intent i;
                    i = new Intent(context, ChatBot.class);
                    context.startActivity(i);
                }
                if(position == 5)
                {
                    Intent i;
                    i = new Intent(context, DetectCrop.class);
                    i.putExtra("type","disease");
                    context.startActivity(i);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView heading,subheading;
        ImageView img;
        CardView card;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             heading =itemView.findViewById(R.id.head_card);
             subheading = itemView.findViewById(R.id.txt_card);
             img=itemView.findViewById(R.id.img_card);
             card = itemView.findViewById(R.id.moreCard);
        }
    }
}
