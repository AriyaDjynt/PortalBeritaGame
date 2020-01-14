package com.hendrysa.portalberitagame.ui.platform;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hendrysa.portalberitagame.AdapterRecycler;
import com.hendrysa.portalberitagame.JSONParser;
import com.hendrysa.portalberitagame.ModelRecycler;
import com.hendrysa.portalberitagame.R;
import com.hendrysa.portalberitagame.Session;
import com.hendrysa.portalberitagame.ui.genre.Genre;
import com.hendrysa.portalberitagame.ui.home.HomeFragment;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

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
    String url = "http://hendrysa.ga:443/project/uasandroid/platform.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platform);

        //Recycler
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager = new LinearLayoutManager(this);
        context = this;
        list = new ArrayList<>();
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(LinearLayoutManager);

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

        new fetchdata().execute();
    }

    class fetchdata extends AsyncTask<String ,String ,String >
    {

        JSONParser jsonParser = new JSONParser();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            list.clear();
        }

        protected String doInBackground(String... args) {
            List<NameValuePair> data = new ArrayList<>();
            data.add(new BasicNameValuePair("platform", platform));
            try
            {
                JSONObject json = jsonParser.makeHttpRequest(url, "POST", data);
                for(int i = 0;i < json.length(); i++)
                {
                    String name = "berita"+String.valueOf(i);
                    JSONObject obj = json.getJSONObject(name);
                    modelRecycler = new ModelRecycler(obj.getString("Thumbnail"));
                    list.add(modelRecycler);
                }
            }
            catch(Exception e)
            {
                Log.d("hendrysa", "Exception : "+String.valueOf(e));
            }
            return null;
        }
        protected void onPostExecute(String e)
        {
            adapterRecycler = new AdapterRecycler(list, context);
            recyclerView.setAdapter(adapterRecycler);
            adapterRecycler.notifyDataSetChanged();
        }
    }
}