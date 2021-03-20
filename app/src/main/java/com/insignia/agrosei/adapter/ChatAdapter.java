package com.insignia.agrosei.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.insignia.agrosei.R;
import com.insignia.agrosei.model.ChatData;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    public ChatAdapter(ArrayList<ChatData> data1) {
        Data1 = data1;
    }

    public ArrayList<ChatData> Data1;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_card,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.t1.setText(Data1.get(position).getEtext());
        if(Data1.get(position).getEid().equals("user")){
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)holder.t1.getLayoutParams();
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            params.setMargins(50,0,0,0);
        }else {
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)holder.t1.getLayoutParams();
            params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            params.setMargins(0,0,50,0);
        }
    }

    @Override
    public int getItemCount() {
        return Data1.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView t1;
        RelativeLayout rel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.chattext);
            cardView = itemView.findViewById(R.id.chatcard);
            rel = itemView.findViewById(R.id.rel_layout);
        }
    }

}
