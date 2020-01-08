package com.hendrysa.portalberitagame.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hendrysa.portalberitagame.AdapterRecycler;
import com.hendrysa.portalberitagame.ModelRecycler;
import com.hendrysa.portalberitagame.R;
import com.hendrysa.portalberitagame.ui.platform.Nintendo;
import com.hendrysa.portalberitagame.ui.platform.Pc;
import com.hendrysa.portalberitagame.ui.platform.Playstation;
import com.hendrysa.portalberitagame.ui.platform.Xbox;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    //Carousel
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5};

    //RecyclerView
    Context context;
    RecyclerView recyclerView;
    androidx.recyclerview.widget.LinearLayoutManager LinearLayoutManager;
    List<ModelRecycler> list;
    ModelRecycler modelRecycler;
    AdapterRecycler adapterRecycler;

    ImageView btn_playstation, btn_pc, btn_nintendo, btn_xbox;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        //Carousel
        carouselView = (CarouselView) view.findViewById(R.id.carouselview);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        //Recycler
        recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager = new LinearLayoutManager(getActivity());
        context = getContext();
        list = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(LinearLayoutManager);
        modelRecycler = new ModelRecycler("https://assets-a2.kompasiana.com/statics/crawl/5559a3700423bd29288b4567.jpeg?t=o&v=350");
        list.add(modelRecycler);
        adapterRecycler = new AdapterRecycler(list, context);
        recyclerView.setAdapter(adapterRecycler);

        btn_nintendo = view.findViewById(R.id.btn_nintendo);
        btn_pc = view.findViewById(R.id.btn_pc);
        btn_xbox = view.findViewById(R.id.btn_xbox);
        btn_playstation = view.findViewById(R.id.btn_playstation);

        btn_playstation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Playstation.class);
                startActivity(i);
            }
        });
        btn_nintendo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Nintendo.class);
                startActivity(i);
            }
        });
        btn_pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Pc.class);
                startActivity(i);
            }
        });
        btn_xbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Xbox.class);
                startActivity(i);
            }
        });
    }
    //Carousel ImageListener
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}