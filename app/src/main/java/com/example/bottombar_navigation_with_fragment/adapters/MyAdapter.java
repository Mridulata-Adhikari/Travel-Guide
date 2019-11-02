package com.example.bottombar_navigation_with_fragment.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottombar_navigation_with_fragment.Festival;
import com.example.bottombar_navigation_with_fragment.Profile;
import com.example.bottombar_navigation_with_fragment.R;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Profile> profiles;
    public View view;


    public MyAdapter(Context c , ArrayList<Profile> p)
    {
        context = c;
        profiles = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(profiles.get(position).getItemtitle());
        holder.descriptionhello.setText(profiles.get(position).getDescription());
        holder.imgurlhello.setText(profiles.get(position).getOverviewimg());
        Picasso.get().load(profiles.get(position).getOverviewimg()).into(holder.profilePic);


    }


    @Override
    public int getItemCount() {
        return profiles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView title, descriptionhello, imgurlhello;
        ImageView profilePic;


        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, Festival.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("Name", title.getText().toString());
                    i.putExtra("Description",descriptionhello.getText().toString());
                    i.putExtra("Image",imgurlhello.getText().toString());
                    i.putExtra("CAT1", "Activities");
                    i.putExtra("CAT2", "Adventure");
                    context.startActivity(i);

                }
            });






            title = (TextView) itemView.findViewById(R.id.movietitle);
            descriptionhello = (TextView)itemView.findViewById(R.id.descriptionhello);
            profilePic = (ImageView) itemView.findViewById(R.id.thumbnail);
            imgurlhello = (TextView)itemView.findViewById(R.id.imgurlhello);

        }

    }
}