package com.insignia.agrosei.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.insignia.agrosei.R;
import com.insignia.agrosei.adapter.GridAdapter;

import java.util.ArrayList;

public class CropActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    GridAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);
        recyclerView = findViewById(R.id.cropsRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        ArrayList<String> Data2 = new ArrayList<String>();
        Data2.add("Volvo");
        Data2.add("BMW");
        Data2.add("Volvo");
        Data2.add("BMW");
        adapter=new GridAdapter(Data2);
        recyclerView.setAdapter(adapter);
    }
}