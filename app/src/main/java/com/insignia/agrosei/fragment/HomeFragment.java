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
import com.insignia.agrosei.CropDetect.DetectCrop;
import com.insignia.agrosei.R;
import com.insignia.agrosei.activity.ChatBot;
import com.insignia.agrosei.activity.MoreActivity;
import com.insignia.agrosei.activity.NewsActivity;
import com.insignia.agrosei.model.Map_locate;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    ImageSlider imageSlider;
    CardView news_card,veggie_finder,expert_chat,farms_card;
    TextView more;


    public HomeFragment() {

    }

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

        View v =  inflater.inflate(R.layout.fragment_home, container, false);
        imageSlider = v.findViewById(R.id.slider);
        news_card = v.findViewById(R.id.card_news);
        veggie_finder = v.findViewById(R.id.card_veggie_finder);
        expert_chat = v.findViewById(R.id.card_expert_chat);
        farms_card = v.findViewById(R.id.card_farm_near_you);
        more = v.findViewById(R.id.tv_more);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://cdn.discordapp.com/attachments/822116671002902553/822960289213055006/Ten-Ways-To-Promote-Your-Homestead.png","Poultry farming guide",ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://cdn.discordapp.com/attachments/822116671002902553/822959786382327808/1286504.png","Mitti ki jaan kaisaan ki shaan",ScaleTypes.CENTER_INSIDE));
        slideModels.add(new SlideModel("https://cdn.discordapp.com/attachments/822116671002902553/822959502080999474/fto-mediakit2020.png","Farmtario-farmers resource book", ScaleTypes.CENTER_INSIDE));
        slideModels.add(new SlideModel("https://cdn.discordapp.com/attachments/822116671002902553/822960228890968084/marketing-tips-banner.png","Ultimate farming tips",ScaleTypes.FIT));


        imageSlider.setImageList(slideModels,ScaleTypes.CENTER_CROP);
        imageSlider.stopSliding();

        news_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),NewsActivity.class);
                startActivity(i);
            }
        });
        veggie_finder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetectCrop.class);
                i.putExtra("type","veggieFinder");
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

        expert_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ChatBot.class);
                startActivity(i);
            }
        });

        farms_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Map_locate.class));
            }
        });

        return v;
    }
}