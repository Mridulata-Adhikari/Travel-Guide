package com.example.bottombar_navigation_with_fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    FirebaseDatabase database;

    RecyclerView first_recycler_view;
    ArrayList<Trips> list;
    TripAdapter adapter;
    private TextView mTextMessage;
    private ActionBar toolbar;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


            View view = inflater.inflate(R.layout.fragment_dashboard,container,false);

            mTextMessage = view.findViewById(R.id.message);

//            FloatingActionButton fab = findViewById(R.id.fab);
//            fab.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    startActivity(new Intent(getContext(), CreateTripActivity.class));
//
//                }
//            });


            first_recycler_view = (RecyclerView) view.findViewById(R.id.recycle1);
            first_recycler_view.setNestedScrollingEnabled(false);
            first_recycler_view.setHasFixedSize(false);

            first_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

            database = FirebaseDatabase.getInstance();
            final DatabaseReference reference = database.getReference().child("trip");
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    list = new ArrayList<Trips>();
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                        Trips p = dataSnapshot1.getValue(Trips.class);
                        list.add(p);
                    }
                    adapter = new TripAdapter(getContext().getApplicationContext(), list);
                    first_recycler_view.setAdapter(adapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(getContext(), "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
                }
            });

            return view;
    }
}
