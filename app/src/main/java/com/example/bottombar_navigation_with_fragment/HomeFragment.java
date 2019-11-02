package com.example.bottombar_navigation_with_fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottombar_navigation_with_fragment.adapters.AttractionAdapter;
import com.example.bottombar_navigation_with_fragment.adapters.CitiesAdapter;
import com.example.bottombar_navigation_with_fragment.adapters.CultureAdapter;
import com.example.bottombar_navigation_with_fragment.adapters.MyAdapter;
import com.example.bottombar_navigation_with_fragment.adapters.NatureAdapter;
import com.example.bottombar_navigation_with_fragment.adapters.RegionAdapter;
import com.example.bottombar_navigation_with_fragment.adapters.SpiritualityAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    String rvid;
    FirebaseDatabase database;
    RecyclerView first_recycler_view, second_recycler_view, third_recycler_view, fourth_recycler_view, fifth_recycler_view, sixth_recycler_view, seventh_recycler_view;
    MyAdapter adapter;
    CultureAdapter cultureAdapter;
    RegionAdapter regionAdapter;
    AttractionAdapter attractionAdapter;
    SpiritualityAdapter spiritualityAdapter;
    NatureAdapter natureAdapter;
    CitiesAdapter citiesAdapter;
    ArrayList<Profile> list;
    FloatingActionButton searchfab;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //just change the fragment_dashboard

        View view = inflater.inflate(R.layout.fragment_home,container,false);


        searchfab = (FloatingActionButton)view.findViewById(R.id.fab2);
        searchfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchOpen = new Intent(getContext().getApplicationContext(),SearchActivity.class);
                startActivity(searchOpen);
            }
        });



        first_recycler_view = (RecyclerView) view.findViewById(R.id.first_recycler_view);
        first_recycler_view.setNestedScrollingEnabled(false);
        first_recycler_view.setHasFixedSize(false);

        first_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        database = FirebaseDatabase.getInstance();
        final DatabaseReference reference = database.getReference().child("Item").child("Activities").child("Adventure");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<Profile>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Profile p = dataSnapshot1.getValue(Profile.class);
                    rvid = "Adventure";

                    list.add(p);
                }
                adapter = new MyAdapter(getContext().getApplicationContext(), list);
                first_recycler_view.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }

        });


        second_recycler_view = (RecyclerView) view.findViewById(R.id.second_recycler_view);
        second_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

//        database = FirebaseDatabase.getInstance();
        final DatabaseReference reference1 = database.getReference().child("Item").child("Activities").child("Culture");
        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<Profile>();
                for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                    Profile p = dataSnapshot2.getValue(Profile.class);
                    list.add(p);
                }
                cultureAdapter = new CultureAdapter(getContext().getApplicationContext(), list);
                second_recycler_view.setAdapter(cultureAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }


        });


        third_recycler_view = (RecyclerView) view.findViewById(R.id.third_recycler_view);
        third_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

//        database = FirebaseDatabase.getInstance();
        final DatabaseReference reference2 = database.getReference().child("Item").child("Activities").child("Nature");
        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<Profile>();
                for (DataSnapshot dataSnapshot3 : dataSnapshot.getChildren()) {
                    Profile p = dataSnapshot3.getValue(Profile.class);
                    list.add(p);
                }
                natureAdapter = new NatureAdapter(getContext().getApplicationContext(), list);
                third_recycler_view.setAdapter(natureAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }


        });

        fourth_recycler_view = (RecyclerView) view.findViewById(R.id.fourth_recycler_view);
        fourth_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

//        database = FirebaseDatabase.getInstance();
        final DatabaseReference reference3 = database.getReference().child("Item").child("Activities").child("Spirituality");
        reference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<Profile>();
                for (DataSnapshot dataSnapshot4 : dataSnapshot.getChildren()) {
                    Profile p = dataSnapshot4.getValue(Profile.class);
                    list.add(p);
                }
                spiritualityAdapter = new SpiritualityAdapter(getContext().getApplicationContext(), list);
                fourth_recycler_view.setAdapter(spiritualityAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }


        });

        fifth_recycler_view = (RecyclerView) view.findViewById(R.id.fifth_recycler_view);
        fifth_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

//        database = FirebaseDatabase.getInstance();
        final DatabaseReference reference4 = database.getReference().child("Item").child("Places").child("Attraction");
        reference4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<Profile>();
                for (DataSnapshot dataSnapshot5 : dataSnapshot.getChildren()) {
                    Profile p = dataSnapshot5.getValue(Profile.class);
                    list.add(p);
                }
                attractionAdapter = new AttractionAdapter(getContext().getApplicationContext(), list);
                fifth_recycler_view.setAdapter(attractionAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }


        });

        sixth_recycler_view = (RecyclerView) view.findViewById(R.id.sixth_recycler_view);
        sixth_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

//        database = FirebaseDatabase.getInstance();
        final DatabaseReference reference5 = database.getReference().child("Item").child("Places").child("Cities");
        reference5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<Profile>();
                for (DataSnapshot dataSnapshot6 : dataSnapshot.getChildren()) {
                    Profile p = dataSnapshot6.getValue(Profile.class);
                    list.add(p);
                }
                citiesAdapter = new CitiesAdapter(getContext().getApplicationContext(), list);
                sixth_recycler_view.setAdapter(citiesAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }


        });

        seventh_recycler_view = (RecyclerView) view.findViewById(R.id.seventh_recycler_view);
        seventh_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

//        database = FirebaseDatabase.getInstance();
        final DatabaseReference reference6 = database.getReference().child("Item").child("Places").child("Region");
        reference6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<Profile>();
                for (DataSnapshot dataSnapshot7 : dataSnapshot.getChildren()) {
                    Profile p = dataSnapshot7.getValue(Profile.class);
                    list.add(p);
                }
                regionAdapter = new RegionAdapter(getContext().getApplicationContext(), list);
                seventh_recycler_view.setAdapter(regionAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }


        });


        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext().getApplicationContext(),AddTrip.class);
                getActivity().startActivity(i);
            }
        });

        FloatingActionButton cam = view.findViewById(R.id.fab3);
        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext().getApplicationContext(), camera.class);
                getActivity().startActivity(i);
            }
        });




        //with the fragment you want to inflate
        //like if the class is HomeFragment it should have R.layout.home_fragment
        //if it is DashboardFragment it should have R.layout.fragment_dashboard
            return view;
    }
}
