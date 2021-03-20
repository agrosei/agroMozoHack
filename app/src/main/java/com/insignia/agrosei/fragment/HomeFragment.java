package com.insignia.agrosei.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.insignia.agrosei.R;
import com.insignia.agrosei.activity.MoreActivity;
import com.insignia.agrosei.activity.NewsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageSlider imageSlider;
    CardView news_card,veggie_finder,expert_chat,farms_card;
    TextView more;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_home, container, false);
        imageSlider = v.findViewById(R.id.slider);
        news_card = v.findViewById(R.id.card_news);
        veggie_finder = v.findViewById(R.id.card_veggie_finder);
        expert_chat = v.findViewById(R.id.card_expert_chat);
        farms_card = v.findViewById(R.id.card_farm_near_you);
        more = v.findViewById(R.id.tv_more);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.rice,"1 Image", ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel("https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832__340.jpg","2 Image",ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel("https://live.staticflickr.com/7006/6621416427_8504865e6a_z.jpg","3 Image",ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel("https://c4.wallpaperflare.com/wallpaper/662/618/496/natur-2560x1600-sceneries-wallpaper-preview.jpg","4 Image",ScaleTypes.CENTER_CROP));
        imageSlider.setImageList(slideModels,ScaleTypes.CENTER_CROP);
        imageSlider.stopSliding();

        news_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),NewsActivity.class);
                startActivity(i);
            }
        });
        more.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), MoreActivity.class);
                startActivity(i);
            }
        });

        return v;
    }
}