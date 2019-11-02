package com.example.bottombar_navigation_with_fragment;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {

    Context context;
    ArrayList<Profile> profiles;
    public View view;


    public SearchAdapter(Context c , ArrayList<Profile> p)
    {
        context = c;
        profiles = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.searchtitle.setText(profiles.get(position).getItemtitle());

        Picasso.get().load(profiles.get(position).getOverviewimg()).into(holder.searchthumbnail);


    }


    @Override
    public int getItemCount() {
        return profiles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView searchtitle;
        ImageView searchthumbnail;

        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;



            searchtitle = (TextView) itemView.findViewById(R.id.searchtitle);

            searchthumbnail = (ImageView) itemView.findViewById(R.id.searchthumbnail);

        }

    }
}