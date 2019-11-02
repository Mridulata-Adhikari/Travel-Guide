package com.example.bottombar_navigation_with_fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androdocs.httprequest.HttpRequest;
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

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Places extends AppCompatActivity {

    TextView textplacetitle, textplacedetail;
    ImageView overviewplaceimage;
    ImageView placeimgtemp;

    String API = "8118ed6ee68db2debfaaa5a44c832918";

     TextView placetemptext,  placeweatherstatus;
    RelativeLayout mainContainer;

    FirebaseDatabase database;

    ArrayList<Profile> list;

    MyAdapter adapter;
    CultureAdapter cultureAdapter;
    RegionAdapter regionAdapter;
    AttractionAdapter attractionAdapter;
    SpiritualityAdapter spiritualityAdapter;
    NatureAdapter natureAdapter;
    CitiesAdapter citiesAdapter;

    RecyclerView rvmoreplace;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);


        textplacetitle = findViewById(R.id.textplacetitle);
        textplacedetail = findViewById(R.id.textplacedetail);
        overviewplaceimage = findViewById(R.id.placeimage);

        placetemptext = findViewById(R.id.weathertempplace);
        placeimgtemp = findViewById(R.id.weatherimgplace);
        placeweatherstatus = findViewById(R.id.weatherstatusplace);


        Intent intent = getIntent();

        String placetitle = intent.getStringExtra("Name");
        String placeimgurl = intent.getStringExtra("Image");
        String placedetail = intent.getStringExtra("Description");
        String mainplacecat = intent.getStringExtra("CAT1");
        String subplacecat = intent.getStringExtra("CAT2");

        textplacetitle.setText(placetitle);
        textplacedetail.setText(placedetail);

        Picasso.get().load(placeimgurl).into(overviewplaceimage);


        rvmoreplace = findViewById(R.id.rvmoreplace);
        rvmoreplace.setNestedScrollingEnabled(false);
        rvmoreplace.setHasFixedSize(true);
        rvmoreplace.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));



        database = FirebaseDatabase.getInstance();
        final DatabaseReference reference = database.getReference().child("Item").child(mainplacecat).child(subplacecat);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<Profile>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Profile p = dataSnapshot1.getValue(Profile.class);
                    String festivaltitleofit = p.getItemtitle();
                    boolean isExists =  placetitle.toLowerCase().equals(festivaltitleofit.toLowerCase());

                    if (isExists) {


                    }
                    else {
                        list.add(p);
                    }



                }

                if (mainplacecat.equals("Places") & subplacecat.equals("Cities")) {

                    citiesAdapter = new CitiesAdapter(getApplicationContext(), list);
                    rvmoreplace.setAdapter(citiesAdapter);

                } else if (mainplacecat.equals("Places") & subplacecat.equals("Region")) {

                    regionAdapter = new RegionAdapter(getApplicationContext(), list);
                    rvmoreplace.setAdapter(regionAdapter);

                } else if (mainplacecat.equals("Place") & subplacecat.equals("Attraction")) {

                    attractionAdapter = new AttractionAdapter(getApplicationContext(), list);
                    rvmoreplace.setAdapter(attractionAdapter);

                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }

        });






        new weathercardTask().execute();


    }

    class weathercardTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            /* Showing the ProgressBar, Making the main design GONE */

        }

        protected String doInBackground(String... args) {
            String response = HttpRequest.excuteGet("https://api.openweathermap.org/data/2.5/weather?q=" + "lamjung,np" + "&units=metric&appid=" + API);

            return response;
        }

        @Override
        protected void onPostExecute(String result) {


            try {
                JSONObject jsonObj = new JSONObject(result);
                JSONObject main = jsonObj.getJSONObject("main");
                JSONObject sys = jsonObj.getJSONObject("sys");
                JSONObject wind = jsonObj.getJSONObject("wind");
                JSONObject weather = jsonObj.getJSONArray("weather").getJSONObject(0);

                Long updatedAt = jsonObj.getLong("dt");
                String updatedAtText = "Updated at: " + new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(new Date(updatedAt * 1000));
                String temp = main.getString("temp") + "°C";
                String tempMin = "Min Temp: " + main.getString("temp_min") + "°C";
                String tempMax = "Max Temp: " + main.getString("temp_max") + "°C";
                String pressure = main.getString("pressure");
                String humidity = main.getString("humidity");

                Long sunrise = sys.getLong("sunrise");
                Long sunset = sys.getLong("sunset");
                String windSpeed = wind.getString("speed");
                String weatherDescription = weather.getString("description");

                String address = jsonObj.getString("name") + ", " + sys.getString("country");

                placetemptext.setText(temp);
                placeweatherstatus.setText(weatherDescription);



//                // get JSONObject from JSON file
//                JSONObject obj = new JSONObject(loadJSONFromAsset());
//                // fetch JSONArray named users
//                JSONArray userArray = obj.getJSONArray("list");
//                // implement for loop for getting users list data
//
//                    // create a JSONObject for fetching single user data
//
//
//                    JSONObject userDetail = userArray.getJSONObject(2);
//                    String time1 = userDetail.getString("dt_txt");
//                    String shortDay1 = convertTimeToDay(time1);
//
//                    JSONObject mainsecond = userDetail.getJSONObject("main");
//                    // fetch email and name and store it in arraylist
//                    day1value.setText(shortDay1);
//                    dayTemp.add(userDetail.getString("email"));
//                    // create a object for getting contact data from JSONObject
//
//                    // fetch mobile number and store it in arraylist












            }
            catch (JSONException e) {

            }

        }

    }


}
