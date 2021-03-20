package com.insignia.agrosei.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import android.widget.ViewFlipper;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.insignia.agrosei.R;
import com.insignia.agrosei.adapter.NewsAdapter;
import com.insignia.agrosei.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    RecyclerView recycler;
    ImageSlider imageSlider;
    NewsAdapter adapter;
    List<NewsModel> models;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        imageSlider = findViewById(R.id.slider);
        recycler = findViewById(R.id.news_recycler);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        models=new ArrayList<>();
        getallData();



        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.rice,ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel("https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832__340.jpg",ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel("https://live.staticflickr.com/7006/6621416427_8504865e6a_z.jpg","3 Image",ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel("https://c4.wallpaperflare.com/wallpaper/662/618/496/natur-2560x1600-sceneries-wallpaper-preview.jpg",ScaleTypes.CENTER_CROP));


        imageSlider.setImageList(slideModels,ScaleTypes.CENTER_CROP);
        imageSlider.stopSliding();



    }

    private void getallData() {

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("newsApi").child("articles");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                models.clear();
                for(DataSnapshot ds:snapshot.getChildren()){
                    NewsModel modelhistory=ds.getValue(NewsModel.class);
                    models.add(modelhistory);
                    adapter=new NewsAdapter(NewsActivity.this,models);
                    recycler.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });
    }
}