package com.example.bottombar_navigation_with_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TripDetail extends AppCompatActivity {


    TextView texttriptitle, texttriplocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_detail);

        String triptitlestring = getIntent().getStringExtra("Name");
        String triplocationstring = getIntent().getStringExtra("Location");


        texttriptitle = (TextView) findViewById(R.id.texttriptitle);

        texttriplocation = (TextView) findViewById(R.id.texttriplocation);

            texttriptitle.setText(triptitlestring);
            texttriplocation.setText("To: "+triplocationstring);

    }
}
