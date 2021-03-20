package com.insignia.agrosei.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.insignia.agrosei.R;
import com.insignia.agrosei.adapter.MoreAdapter;
import com.insignia.agrosei.model.MoreModel;

import java.util.ArrayList;

public class MoreActivity extends AppCompatActivity {

    RecyclerView recycler;
    MoreAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);


        recycler = findViewById(R.id.recyclerView);
        ArrayList<MoreModel> Data2 = new ArrayList<MoreModel>();
        Data2.add(new MoreModel("https://agro.events/images/64/26/19/40495.png","Agro Events","Agricultural Events from around the world"));
        Data2.add(new MoreModel("https://pbs.twimg.com/profile_images/1215538343586467840/kNxzL0DN_400x400.jpg","Agro News","Daily Refreshing news"));
        Data2.add(new MoreModel("https://image.freepik.com/free-vector/chat-speech-bubble-icon_23-2147501656.jpg","Expert Chat","Chat with Experts"));
        Data2.add(new MoreModel("https://www.pngitem.com/pimgs/m/160-1606422_loan-government-funding-icon-png-transparent-png.png","Government Funds","Subsidies and Funds"));
        Data2.add(new MoreModel("https://valueindia.net/wp-content/uploads/2020/07/Apeda-logo-web.jpg","Seed Certifications","buy and sell certified seeds"));
        Data2.add(new MoreModel("https://live.staticflickr.com/7006/6621416427_8504865e6a_z.jpg","Pest and Diseases Control","Pest and Diseases Control Measures"));

        adapter = new MoreAdapter(this,Data2);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recycler.setAdapter(adapter);
    }
}