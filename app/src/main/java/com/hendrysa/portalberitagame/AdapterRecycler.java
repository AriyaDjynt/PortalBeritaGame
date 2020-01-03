package com.hendrysa.portalberitagame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.modelViewHolder> {

    List<ModelRecycler> myList;
    Context context;

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
    public void onBindViewHolder(@NonNull AdapterRecycler.modelViewHolder holder, int position) {
        Glide.with(this.context).load(myList.get(position).getImg()).thumbnail(0.5f).crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.row_img);
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
}
