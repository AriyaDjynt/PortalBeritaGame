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
import com.hendrysa.portalberitagame.Session;
import com.hendrysa.portalberitagame.ui.genre.Genre;

import java.util.ArrayList;
import java.util.List;

public class Platform extends AppCompatActivity {
    //RecyclerView
    Context context;
    RecyclerView recyclerView;
    LinearLayoutManager LinearLayoutManager;
    List<ModelRecycler> list;
    ModelRecycler modelRecycler;
    AdapterRecycler adapterRecycler;

    String platform;
    TextView txt_platform;
    ImageView btn_action, btn_simulation, btn_strategy, btn_adventure, btn_shooting, btn_fighting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platform);

        //Recycler
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager = new LinearLayoutManager(this);
        list = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(LinearLayoutManager);
        //modelRecycler = new ModelRecycler("https://assets-a2.kompasiana.com/statics/crawl/5559a3700423bd29288b4567.jpeg?t=o&v=350");
        //list.add(modelRecycler);
        adapterRecycler = new AdapterRecycler(list, this);
        recyclerView.setAdapter(adapterRecycler);

        platform = getIntent().getStringExtra("platform");

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
                Intent i = new Intent(getApplicationContext(), Genre.class);
                i.putExtra("platform", platform);
                i.putExtra("genre", "Action");
                startActivity(i);
            }
        });
        btn_adventure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Genre.class);
                i.putExtra("platform", platform);
                i.putExtra("genre", "Adventure");
                startActivity(i);
            }
        });
        btn_simulation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Genre.class);
                i.putExtra("platform", platform);
                i.putExtra("genre", "Simulation");
                startActivity(i);
            }
        });
        btn_shooting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Genre.class);
                i.putExtra("platform", platform);
                i.putExtra("genre", "Shooting");
                startActivity(i);
            }
        });
        btn_strategy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Genre.class);
                i.putExtra("platform", platform);
                i.putExtra("genre", "Strategy");
                startActivity(i);
            }
        });
        btn_fighting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Genre.class);
                i.putExtra("platform", platform);
                i.putExtra("genre", "Fighting");
                startActivity(i);
            }
        });
    }
}