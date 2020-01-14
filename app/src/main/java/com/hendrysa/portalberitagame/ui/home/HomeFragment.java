package com.hendrysa.portalberitagame.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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
import com.hendrysa.portalberitagame.JSONParser;
import com.hendrysa.portalberitagame.MainActivity;
import com.hendrysa.portalberitagame.ModelRecycler;
import com.hendrysa.portalberitagame.R;
import com.hendrysa.portalberitagame.Session;
import com.hendrysa.portalberitagame.ui.platform.Platform;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

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
    String url = "http://hendrysa.ga:443/project/uasandroid/mostview.php";

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
        list.clear();
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(LinearLayoutManager);

        btn_nintendo = view.findViewById(R.id.btn_nintendo);
        btn_pc = view.findViewById(R.id.btn_pc);
        btn_xbox = view.findViewById(R.id.btn_xbox);
        btn_playstation = view.findViewById(R.id.btn_playstation);

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
        new fetchdata().execute();
    }
    //Carousel ImageListener
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            //imageView.setImageResource(sampleImages[1]);
        }
    };

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