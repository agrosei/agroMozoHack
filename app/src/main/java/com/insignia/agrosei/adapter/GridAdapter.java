package com.insignia.agrosei.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.insignia.agrosei.R;
import com.insignia.agrosei.activity.TimeLineActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    public ArrayList<?> Data2;
    HashMap<Integer,ViewHolder> Card=new HashMap<>();
     public Context context;
    //  public List<UploadTask> uploadTasks;
    Activity thisActivity;

    public GridAdapter(Context context, ArrayList<?> data) {
        Data2 = data;
        this.context = context;
        //   this.context = context;
        //   this.uploadTasks = uploadTasks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.crops_card,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cropName.setText("Crop Name");
        holder.time.setText("Time");
        holder.recommended.setText("Recommended");
        holder.cropProgress.setProgress(75);
        Picasso.get().load("https://kj1bcdn.b-cdn.net/media/8468/hybrid-paddy-godavari-inuk405.jpg").fit().into(holder.cropImg);
        holder.cropCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, TimeLineActivity.class);
                context.startActivity(i);
            }
        });
    }

    public ViewHolder getView(int pos){return Card.get(pos);}

    @Override
    public int getItemCount() {
        return Data2.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView cropName,time,recommended;
        ImageView cropImg;
        ProgressBar cropProgress;
        CardView cropCard;

        public ViewHolder(@NonNull android.view.View itemView) {
            super(itemView);
            cropImg = itemView.findViewById(R.id.crops_image);
            cropName = itemView.findViewById(R.id.crops);
            time = itemView.findViewById(R.id.time);
            recommended = itemView.findViewById(R.id.recommended);
            cropProgress = itemView.findViewById(R.id.progress);
            cropCard = itemView.findViewById(R.id.crop_card);
        }
    }
}