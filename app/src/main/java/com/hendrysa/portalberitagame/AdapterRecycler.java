package com.hendrysa.portalberitagame;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hendrysa.portalberitagame.ui.webview.Webview;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.modelViewHolder> {

    List<ModelRecycler> myList;
    Context context;
    String url = "http://hendrysa.ga:443/project/uasandroid/geturl.php";
    String thumb;

    public AdapterRecycler(List<ModelRecycler> myList, Context context){
        this.myList = myList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterRecycler.modelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.recycler_item,parent,false);
        modelViewHolder obj = new modelViewHolder(view);
        return obj ;
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterRecycler.modelViewHolder holder, final int position)
    {
        Glide.with(this.context).load(myList.get(position).getImg()).thumbnail(0.5f).crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.row_img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thumb = myList.get(position).getImg();
                new fetchdata().execute();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class modelViewHolder extends RecyclerView.ViewHolder{

        ImageView row_img;

        public modelViewHolder(@NonNull View itemView){
            super(itemView);

            row_img = itemView.findViewById(R.id.linear_item);
        }
    }

    class fetchdata extends AsyncTask<String ,String ,String >
    {

        JSONParser jsonParser = new JSONParser();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... args) {
            List<NameValuePair> data = new ArrayList<>();
            data.add(new BasicNameValuePair("thumbnail", thumb));
            try
            {
                JSONObject json = jsonParser.makeHttpRequest(url, "POST", data);
                if(json.getInt("success") == 1)
                {
                    String Link = json.getString("Link");
                    Intent i = new Intent(context, Webview.class);
                    i.putExtra("link",Link);
                    context.startActivity(i);
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
        }
    }
}
