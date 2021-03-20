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
import com.insignia.agrosei.R;
import com.insignia.agrosei.activity.NewsActivity;
import com.insignia.agrosei.activity.SingleNewsActivity;
import com.insignia.agrosei.activity.webNews;
import com.insignia.agrosei.model.NewsModel;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
Context context;
    public List<NewsModel> Data;


    public NewsAdapter(Context context, List<NewsModel> data) {
        this.context = context;
        Data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        String content=Data.get(position).getContent();
        String publish=Data.get(position).getPublishedAt();
        String title=Data.get(position).getTitle();
        String urls=Data.get(position).getUrl();
        String urltoimage=Data.get(position).getUrlToImage();
        holder.heading.setText(title);
        holder.subheading.setText(content);
        Picasso.get().load(urltoimage).fit().into(holder.img);
        holder.itemView.setOnClickListener(view -> {
            Intent i = new Intent(context, webNews.class);
            i.putExtra("link",urls);
            context.startActivity(i);
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
             heading =itemView.findViewById(R.id.tv_card_news_header);
             subheading = itemView.findViewById(R.id.tv_card_news_content);
             img=itemView.findViewById(R.id.img_card_news);
             card = itemView.findViewById(R.id.card);
        }
    }
}
