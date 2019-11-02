package com.example.bottombar_navigation_with_fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.bottombar_navigation_with_fragment.adapters.MyAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    String searchString;
    EditText editSearch;
    ImageButton searchit;
    FirebaseDatabase database;
    MyAdapter adapter;
    ArrayList<Profile> list;

    RecyclerView first_recycler_view_search, second_recycler_view_search, third_recycler_view_search, fourth_recycler_view_search, fifth_recycler_view_search, sixth_recycler_view_search, seventh_recycler_view_search;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editSearch = (EditText)findViewById(R.id.editsearch);
        searchit = (ImageButton)findViewById(R.id.btntoSearch);


        searchit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                first_recycler_view_search = (RecyclerView) findViewById(R.id.first_recycler_view_search);
                first_recycler_view_search.setNestedScrollingEnabled(false);
                first_recycler_view_search.setHasFixedSize(false);

                first_recycler_view_search.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

                database = FirebaseDatabase.getInstance();
                final DatabaseReference reference = database.getReference().child("Item").child("Activities").child("Adventure");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        searchString = editSearch.getText().toString();
                        list = new ArrayList<Profile>();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            Profile p = dataSnapshot1.getValue(Profile.class);

                            String titleofit = p.getDescription();
                            boolean isExists = titleofit.toLowerCase().contains(editSearch.getText().toString().toLowerCase());
                            if(isExists) {
                                System.out.println(titleofit);
                                list.add(p);
                            }else {

                            }


                        }
                        adapter = new MyAdapter(getApplicationContext(), list);
                        first_recycler_view_search.setAdapter(adapter);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
                    }

                });




                third_recycler_view_search = (RecyclerView) findViewById(R.id.third_recycler_view_search);
                third_recycler_view_search.setNestedScrollingEnabled(false);
                third_recycler_view_search.setHasFixedSize(false);

                third_recycler_view_search.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

                database = FirebaseDatabase.getInstance();
                final DatabaseReference reference2 = database.getReference().child("Item").child("Activities").child("Nature");
                reference2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        searchString = editSearch.getText().toString();
                        list = new ArrayList<Profile>();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            Profile p = dataSnapshot1.getValue(Profile.class);

                            String titleofit = p.getDescription();
                            boolean isExists = titleofit.toLowerCase().contains(editSearch.getText().toString().toLowerCase());
                            if(isExists) {
                                System.out.println(titleofit);
                                list.add(p);
                            }else {

                            }


                        }
                        adapter = new MyAdapter(getApplicationContext(), list);
                        third_recycler_view_search.setAdapter(adapter);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
                    }

                });




                second_recycler_view_search = (RecyclerView) findViewById(R.id.second_recycler_view_search);
                second_recycler_view_search.setNestedScrollingEnabled(false);
                second_recycler_view_search.setHasFixedSize(false);

                second_recycler_view_search.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

                database = FirebaseDatabase.getInstance();
                final DatabaseReference reference1 = database.getReference().child("Item").child("Activities").child("Culture");
                reference1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        searchString = editSearch.getText().toString();
                        list = new ArrayList<Profile>();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            Profile p = dataSnapshot1.getValue(Profile.class);

                            String titleofit = p.getDescription();
                            boolean isExists = titleofit.toLowerCase().contains(editSearch.getText().toString().toLowerCase());
                            if(isExists) {
                                System.out.println(titleofit);
                                list.add(p);
                            }else {

                            }


                        }
                        adapter = new MyAdapter(getApplicationContext(), list);
                        second_recycler_view_search.setAdapter(adapter);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
                    }

                });



                fourth_recycler_view_search = (RecyclerView) findViewById(R.id.fourth_recycler_view_search);
                fourth_recycler_view_search.setNestedScrollingEnabled(false);
                fourth_recycler_view_search.setHasFixedSize(false);

                fourth_recycler_view_search.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

                database = FirebaseDatabase.getInstance();
                final DatabaseReference reference3 = database.getReference().child("Item").child("Activities").child("Spirituality");
                reference3.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        searchString = editSearch.getText().toString();
                        list = new ArrayList<Profile>();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            Profile p = dataSnapshot1.getValue(Profile.class);

                            String titleofit = p.getDescription();
                            boolean isExists = titleofit.toLowerCase().contains(editSearch.getText().toString().toLowerCase());
                            if(isExists) {
                                System.out.println(titleofit);
                                list.add(p);
                            }else {

                            }


                        }
                        adapter = new MyAdapter(getApplicationContext(), list);
                        fourth_recycler_view_search.setAdapter(adapter);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
                    }

                });



                fifth_recycler_view_search = (RecyclerView) findViewById(R.id.fifth_recycler_view_search);
                fifth_recycler_view_search.setNestedScrollingEnabled(false);
                fifth_recycler_view_search.setHasFixedSize(false);

                fifth_recycler_view_search.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

                database = FirebaseDatabase.getInstance();
                final DatabaseReference reference4 = database.getReference().child("Item").child("Places").child("Attraction");
                reference4.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        searchString = editSearch.getText().toString();
                        list = new ArrayList<Profile>();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            Profile p = dataSnapshot1.getValue(Profile.class);

                            String titleofit = p.getDescription();
                            boolean isExists = titleofit.toLowerCase().contains(editSearch.getText().toString().toLowerCase());
                            if(isExists) {
                                System.out.println(titleofit);
                                list.add(p);
                            }else {

                            }


                        }
                        adapter = new MyAdapter(getApplicationContext(), list);
                        fifth_recycler_view_search.setAdapter(adapter);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
                    }

                });



                sixth_recycler_view_search = (RecyclerView) findViewById(R.id.sixth_recycler_view_search);
                sixth_recycler_view_search.setNestedScrollingEnabled(false);
                sixth_recycler_view_search.setHasFixedSize(false);

                sixth_recycler_view_search.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

                database = FirebaseDatabase.getInstance();
                final DatabaseReference reference5 = database.getReference().child("Item").child("Places").child("Cities");
                reference5.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        searchString = editSearch.getText().toString();
                        list = new ArrayList<Profile>();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            Profile p = dataSnapshot1.getValue(Profile.class);

                            String titleofit = p.getDescription();
                            boolean isExists = titleofit.toLowerCase().contains(editSearch.getText().toString().toLowerCase());
                            if(isExists) {
                                System.out.println(titleofit);
                                list.add(p);
                            }else {

                            }


                        }
                        adapter = new MyAdapter(getApplicationContext(), list);
                        sixth_recycler_view_search.setAdapter(adapter);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
                    }

                });




                seventh_recycler_view_search = (RecyclerView) findViewById(R.id.seventh_recycler_view_search);
                seventh_recycler_view_search.setNestedScrollingEnabled(false);
                seventh_recycler_view_search.setHasFixedSize(false);

                seventh_recycler_view_search.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

                database = FirebaseDatabase.getInstance();
                final DatabaseReference reference6 = database.getReference().child("Item").child("Places").child("Region");
                reference6.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        searchString = editSearch.getText().toString();
                        list = new ArrayList<Profile>();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            Profile p = dataSnapshot1.getValue(Profile.class);

                            String titleofit = p.getDescription();
                            boolean isExists = titleofit.toLowerCase().contains(editSearch.getText().toString().toLowerCase());
                            if(isExists) {
                                System.out.println(titleofit);
                                list.add(p);
                            }else {

                            }


                        }
                        adapter = new MyAdapter(getApplicationContext(), list);
                        seventh_recycler_view_search.setAdapter(adapter);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
                    }

                });






            }
        });





    }
}
