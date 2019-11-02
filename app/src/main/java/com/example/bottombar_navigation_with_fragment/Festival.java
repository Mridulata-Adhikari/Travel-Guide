package com.example.bottombar_navigation_with_fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bottombar_navigation_with_fragment.adapters.AttractionAdapter;
import com.example.bottombar_navigation_with_fragment.adapters.CitiesAdapter;
import com.example.bottombar_navigation_with_fragment.adapters.CultureAdapter;
import com.example.bottombar_navigation_with_fragment.adapters.MyAdapter;
import com.example.bottombar_navigation_with_fragment.adapters.NatureAdapter;
import com.example.bottombar_navigation_with_fragment.adapters.RegionAdapter;
import com.example.bottombar_navigation_with_fragment.adapters.SpiritualityAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Festival extends AppCompatActivity {

    TextView textfestivaltitle, textfestivaldetail;
    ImageView overviewfestivalimage;
    ArrayList<Profile> list;

    FirebaseDatabase database;

    MyAdapter adapter;
    CultureAdapter cultureAdapter;
    RegionAdapter regionAdapter;
    AttractionAdapter attractionAdapter;
    SpiritualityAdapter spiritualityAdapter;
    NatureAdapter natureAdapter;
    CitiesAdapter citiesAdapter;





    RecyclerView rvmorefestival;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival);


        textfestivaldetail = findViewById(R.id.textfestivaldetail);
        textfestivaltitle = findViewById(R.id.textfestivaltitle);
        overviewfestivalimage = findViewById(R.id.festivalimage);



        Intent intent = getIntent();

        String festivalname = intent.getStringExtra("Name");
        String festivaldetail = intent.getStringExtra("Description");
        String festivalimgurl = intent.getStringExtra("Image");
        String mainfestivalcat = intent.getStringExtra("CAT1");
        String subfestivalcat = intent.getStringExtra("CAT2");


        textfestivaltitle.setText(festivalname);
        textfestivaldetail.setText(festivaldetail);
        Picasso.get().load(festivalimgurl).into(overviewfestivalimage);

        rvmorefestival = findViewById(R.id.rvmorefestival);
        rvmorefestival.setNestedScrollingEnabled(false);
        rvmorefestival.setHasFixedSize(true);
        rvmorefestival.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        database = FirebaseDatabase.getInstance();
        final DatabaseReference reference = database.getReference().child("Item").child(mainfestivalcat).child(subfestivalcat);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<Profile>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Profile p = dataSnapshot1.getValue(Profile.class);
                    String festivaltitleofit = p.getItemtitle();
                    boolean isExists =  festivalname.toLowerCase().equals(festivaltitleofit.toLowerCase());

                    if (isExists) {


                    }
                    else {
                        list.add(p);
                    }



                }

                if (mainfestivalcat.equals("Activities") & subfestivalcat.equals("Adventure")) {

                    adapter = new MyAdapter(getApplicationContext(), list);
                    rvmorefestival.setAdapter(adapter);

                } else if (mainfestivalcat.equals("Activities") & subfestivalcat.equals("Culture")) {

                    cultureAdapter = new CultureAdapter(getApplicationContext(), list);
                    rvmorefestival.setAdapter(cultureAdapter);

                } else if (mainfestivalcat.equals("Activities") & subfestivalcat.equals("Nature")) {

                    natureAdapter = new NatureAdapter(getApplicationContext(), list);
                    rvmorefestival.setAdapter(natureAdapter);

                } else if (mainfestivalcat.equals("Activities") & subfestivalcat.equals("Spirituality")) {

                    spiritualityAdapter = new SpiritualityAdapter(getApplicationContext(), list);
                    rvmorefestival.setAdapter(spiritualityAdapter);

                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }

        });









    }
}
