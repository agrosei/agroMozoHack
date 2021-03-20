package com.insignia.agrosei.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.insignia.agrosei.R;
import com.insignia.agrosei.adapter.TimeLineAdapter;
import com.insignia.agrosei.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

public class TimeLineActivity extends AppCompatActivity {

    RecyclerView recycler ;
    TimeLineAdapter adapter;
    ArrayList<String> adapterList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);

        recycler = findViewById(R.id.timeline_recycler);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapterList.add("TODO");
        adapterList.add("TODO");
        adapter = new TimeLineAdapter(getApplicationContext(),adapterList);
        recycler.setAdapter(adapter);

    }
}