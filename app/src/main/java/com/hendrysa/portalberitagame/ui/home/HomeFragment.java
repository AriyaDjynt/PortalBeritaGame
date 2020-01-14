package com.hendrysa.portalberitagame.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hendrysa.portalberitagame.AdapterRecycler;
import com.hendrysa.portalberitagame.ModelRecycler;
import com.hendrysa.portalberitagame.R;
import com.hendrysa.portalberitagame.Session;
import com.hendrysa.portalberitagame.ui.platform.Platform;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    //Carousel
    CarouselView carouselView;
    String[] sampleImages;

    //RecyclerView
    Context context;
    RecyclerView recyclerView;
    androidx.recyclerview.widget.LinearLayoutManager LinearLayoutManager;
    List<ModelRecycler> list;
    ModelRecycler modelRecycler;
    AdapterRecycler adapterRecycler;

    ImageView btn_playstation, btn_pc, btn_nintendo, btn_xbox;
    TextView txt_logged;

    private Session session;

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
        sampleImages = new String[] {"https://assets-a2.kompasiana.com/statics/crawl/5559a3700423bd29288b4567.jpeg?t=o&v=350", "https://assets-a2.kompasiana.com/statics/crawl/5559a3700423bd29288b4567.jpeg?t=o&v=350"};
        carouselView = (CarouselView) view.findViewById(R.id.carouselview);
        carouselView.setImageListener(imageListener);
        carouselView.setPageCount(sampleImages.length);

        //Recycler
        recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager = new LinearLayoutManager(getActivity());
        context = getContext();
        list = new ArrayList<>();
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(LinearLayoutManager);
        modelRecycler = new ModelRecycler("https://assets-a2.kompasiana.com/statics/crawl/5559a3700423bd29288b4567.jpeg?t=o&v=350");
        list.add(modelRecycler);
        modelRecycler = new ModelRecycler("https://miro.medium.com/max/3840/1*l36v3Zr_tdzrIDk4pdg1rw.jpeg");
        list.add(modelRecycler);
        modelRecycler = new ModelRecycler("https://assets-a2.kompasiana.com/statics/crawl/5559a3700423bd29288b4567.jpeg?t=o&v=350");
        list.add(modelRecycler);
        modelRecycler = new ModelRecycler("https://miro.medium.com/max/3840/1*l36v3Zr_tdzrIDk4pdg1rw.jpeg");
        list.add(modelRecycler);
        adapterRecycler = new AdapterRecycler(list, context);
        recyclerView.setAdapter(adapterRecycler);

        btn_nintendo = view.findViewById(R.id.btn_nintendo);
        btn_pc = view.findViewById(R.id.btn_pc);
        btn_xbox = view.findViewById(R.id.btn_xbox);
        btn_playstation = view.findViewById(R.id.btn_playstation);

        session = new Session(getActivity());
        txt_logged = view.findViewById(R.id.txt_logged_username);

        btn_playstation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Platform.class);
                i.putExtra("platform","Playstation");
                startActivity(i);
            }
        });
        btn_nintendo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Platform.class);
                i.putExtra("platform","Nintendo");
                startActivity(i);
            }
        });
        btn_pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Platform.class);
                i.putExtra("platform","PC");
                startActivity(i);
            }
        });
        btn_xbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Platform.class);
                i.putExtra("platform","XBOX");
                startActivity(i);
            }
        });
    }
    //Carousel ImageListener
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            //imageView.setImageResource(sampleImages[1]);
        }
    };
}