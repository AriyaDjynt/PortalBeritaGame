package com.hendrysa.portalberitagame.ui.search;

import android.content.Context;
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
import com.hendrysa.portalberitagame.ui.platform.Platform;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity {

    //RecyclerView
    Context context;
    RecyclerView recyclerView;
    androidx.recyclerview.widget.LinearLayoutManager LinearLayoutManager;
    List<ModelRecycler> list;
    ModelRecycler modelRecycler;
    AdapterRecycler adapterRecycler;

    ImageView btn_search;
    TextView txt_search;
    String Search;
    String url = "http://hendrysa.ga:443/project/uasandroid/search.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //Recycler
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager = new LinearLayoutManager(this);
        context = this;
        list = new ArrayList<>();
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(LinearLayoutManager);

        btn_search = findViewById(R.id.btn_search);
        txt_search = findViewById(R.id.field_search);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Search = txt_search.getText().toString();
                new fetchdata().execute();
            }
        });

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
            data.add(new BasicNameValuePair("search", Search));
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
