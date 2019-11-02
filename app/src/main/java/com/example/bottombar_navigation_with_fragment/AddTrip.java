package com.example.bottombar_navigation_with_fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddTrip extends AppCompatActivity {


    EditText edttripstartdate, edttripname;
    Button addtripbtn;
    private String Userid;
    String tripname, tripstartdate;
    FirebaseDatabase database;
    DatabaseReference reference, postsRef;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);

        edttripname = (EditText)findViewById(R.id.edttripname);
        edttripstartdate = (EditText)findViewById(R.id.edttripstartdate);
        addtripbtn = (Button)findViewById(R.id.addtripbtn);

        tripname = edttripname.getText().toString();
        tripstartdate = edttripstartdate.getText().toString();

        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        postsRef = reference.child("trip");


        addtripbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tripname = edttripname.getText().toString();
                tripstartdate = edttripstartdate.getText().toString();
                
                if (TextUtils.isEmpty(Userid)) {
                    createUser(tripname, tripstartdate);
                    finish();
                }
                else {
                    updateUser(tripname, tripstartdate);
                    finish();
                }

            }
        });

    }

    private void createUser (String tripname, String tripstartdate) {

        if(TextUtils.isEmpty(Userid)) {
            Userid = postsRef.push().getKey();
        }

        Trips trips = new Trips(tripname,"", tripstartdate);
        postsRef.push().setValue(trips);
        addUserChangeListener();


    }

    private void addUserChangeListener() {

            postsRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    Trips trips = dataSnapshot.getValue(Trips.class);

                    if (trips == null ) {
                        Log.e(TAG,"User data is null" );
                        return;
                    }
                    Log.e(TAG, "User data is change! " );

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    Log.e(TAG, "Failed to read User ", databaseError.toException());


                }
            });

    }

    private void updateUser (String tripname, String tripstartdate) {

        if(!TextUtils.isEmpty(tripname)) {
            postsRef.child(Userid).child("name").setValue(tripname);
        }
        if(!TextUtils.isEmpty(tripstartdate)) {
            postsRef.child(Userid).child("datefrom").setValue(tripstartdate);
        }

    }




}
