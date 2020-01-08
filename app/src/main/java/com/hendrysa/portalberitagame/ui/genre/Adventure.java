package com.hendrysa.portalberitagame.ui.genre;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hendrysa.portalberitagame.AdapterRecycler;
import com.hendrysa.portalberitagame.ModelRecycler;
import com.hendrysa.portalberitagame.R;

import java.util.ArrayList;
import java.util.List;

public class Adventure extends AppCompatActivity {
    //RecyclerView
    Context context;
    RecyclerView recyclerView;
    androidx.recyclerview.widget.LinearLayoutManager LinearLayoutManager;
    List<ModelRecycler> list;
    ModelRecycler modelRecycler;
    AdapterRecycler adapterRecycler;

    String platform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

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

        platform = getIntent().getStringExtra("platform");
        Log.d("hendrysa", platform);
    }
}
