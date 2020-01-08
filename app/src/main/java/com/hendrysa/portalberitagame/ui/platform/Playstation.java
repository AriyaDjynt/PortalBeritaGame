package com.hendrysa.portalberitagame.ui.platform;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hendrysa.portalberitagame.AdapterRecycler;
import com.hendrysa.portalberitagame.ModelRecycler;
import com.hendrysa.portalberitagame.R;
import com.hendrysa.portalberitagame.ui.genre.Action;
import com.hendrysa.portalberitagame.ui.genre.Adventure;
import com.hendrysa.portalberitagame.ui.genre.Fighting;
import com.hendrysa.portalberitagame.ui.genre.Shooting;
import com.hendrysa.portalberitagame.ui.genre.Simulation;
import com.hendrysa.portalberitagame.ui.genre.Strategy;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class Playstation extends AppCompatActivity {
    //RecyclerView
    Context context;
    RecyclerView recyclerView;
    LinearLayoutManager LinearLayoutManager;
    List<ModelRecycler> list;
    ModelRecycler modelRecycler;
    AdapterRecycler adapterRecycler;

    String platform = "Playstation";
    TextView txt_platform;
    ImageView btn_action, btn_simulation, btn_strategy, btn_adventure, btn_shooting, btn_fighting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platform);

        //Recycler
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager = new LinearLayoutManager(this);
        context = this;
        list = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(LinearLayoutManager);
        modelRecycler = new ModelRecycler("https://assets-a2.kompasiana.com/statics/crawl/5559a3700423bd29288b4567.jpeg?t=o&v=350");
        list.add(modelRecycler);
        adapterRecycler = new AdapterRecycler(list, context);
        recyclerView.setAdapter(adapterRecycler);

        txt_platform = findViewById(R.id.txt_platform);
        txt_platform.setText(platform);

        btn_action = findViewById(R.id.btn_action);
        btn_adventure = findViewById(R.id.btn_adventure);
        btn_simulation = findViewById(R.id.btn_simulation);
        btn_strategy = findViewById(R.id.btn_strategy);
        btn_shooting = findViewById(R.id.btn_shooting);
        btn_fighting = findViewById(R.id.btn_fighting);

        btn_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Action.class);
                i.putExtra("platform", platform);
                startActivity(i);
            }
        });
        btn_adventure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Adventure.class);
                i.putExtra("platform", platform);
                startActivity(i);
            }
        });
        btn_strategy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Strategy.class);
                i.putExtra("platform", platform);
                startActivity(i);
            }
        });
        btn_shooting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Shooting.class);
                i.putExtra("platform", platform);
                startActivity(i);
            }
        });
        btn_simulation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Simulation.class);
                i.putExtra("platform", platform);
                startActivity(i);
            }
        });
        btn_fighting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Fighting.class);
                i.putExtra("platform", platform);
                startActivity(i);
            }
        });

        //Recycler
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager = new LinearLayoutManager(this);
        context = this;
        list = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(LinearLayoutManager);

        modelRecycler = new ModelRecycler("https://assets-a2.kompasiana.com/statics/crawl/5559a3700423bd29288b4567.jpeg?t=o&v=350");
        list.add(modelRecycler);

        adapterRecycler = new AdapterRecycler(list, context);
        recyclerView.setAdapter(adapterRecycler);
    }

}