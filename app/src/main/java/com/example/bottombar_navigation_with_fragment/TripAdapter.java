package com.example.bottombar_navigation_with_fragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.MyViewHolder> {

    Context context;
    ArrayList<Trips> trips;

    public View view;

    public TripAdapter(Context c , ArrayList<Trips> t)
    {
        context = c;
        trips = t;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.trips_card, parent, false);
        return new MyViewHolder(v);}

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.name.setText(trips.get(position).getName());
        holder.location.setText(trips.get(position).getLocation());
//        holder.datefrom.setText(trips.get(position).getDatefrom());
//        holder.dateto.setText(trips.get(position).getDateto());



    }

    @Override
    public int getItemCount() {
        return trips.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        TextView location;
        TextView datefrom;
        TextView dateto;

        public MyViewHolder(View itemView) {
            super(itemView);

            view = itemView;

            view.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent i = new Intent(context, TripDetail.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("Name", name.getText());
                    i.putExtra("Location", location.getText());
                    context.startActivity(i);

                }
            });



            name = (TextView) itemView.findViewById(R.id.name);
            location = (TextView) itemView.findViewById(R.id.location);
//            datefrom = (TextView) itemView.findViewById(R.id.datefrom);
//            dateto = (TextView) itemView.findViewById(R.id.dateto);




        }

    }
}