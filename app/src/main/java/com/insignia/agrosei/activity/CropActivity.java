package com.insignia.agrosei.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.insignia.agrosei.R;
import com.insignia.agrosei.adapter.GridAdapter;
import com.insignia.agrosei.model.ChatData;
import com.insignia.agrosei.model.CropData;

import java.util.ArrayList;

public class CropActivity extends AppCompatActivity {
    ArrayList<CropData> Data2 = new ArrayList<>();
    RecyclerView recyclerView;
    GridAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);
        recyclerView = findViewById(R.id.cropsRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        Data2.add(new CropData("Wheat","3-4 months",20,"https://upload.wikimedia.org/wikipedia/commons/b/b4/Wheat_close-up.JPG"));
        Data2.add(new CropData("Rice","5-6 months",50,"https://assets.thehansindia.com/h-upload/feeds/2019/07/13/195638-paddy-crop.jpg"));
        Data2.add(new CropData("Groundnut","7-8 months",70,"https://kj1bcdn.b-cdn.net/media/24665/nut.jpg"));
        Data2.add(new CropData("Sugarcane","10-12 months",90,"https://cdn.s3waas.gov.in/s366f041e16a60928b05a7e228a89c3799/uploads/bfi_thumb/2019062257-olw919mwwbepbrxmxqwxpmsh3btlyk1bi7p0si6g92.jpg"));
        adapter=new GridAdapter(getApplicationContext(),Data2);
        recyclerView.setAdapter(adapter);
    }
}