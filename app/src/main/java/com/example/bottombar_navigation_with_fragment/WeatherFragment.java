package com.example.bottombar_navigation_with_fragment;

import android.os.AsyncTask;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.androdocs.httprequest.HttpRequest;

import org.json.JSONException;
import org.json.JSONObject;

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

public class WeatherFragment extends Fragment {



    String CITY = "kathmandu,np";
    String API = "8118ed6ee68db2debfaaa5a44c832918";

    TextView addressTxt, updated_atTxt, statusTxt, tempTxt, temp_minTxt, temp_maxTxt, sunriseTxt,
            sunsetTxt, windTxt, pressureTxt, humidityTxt, errorText,day1value, day2value, day3value, day4value, day5value,
            day1temp, day2temp, day3temp, day4temp, day5temp;
    ProgressBar progressBar;
    RelativeLayout mainContainer;

    ArrayList<String> dayName = new ArrayList<>();
    ArrayList<String> dayTemp = new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather,container,false);


        addressTxt = view.findViewById(R.id.address);
        updated_atTxt = view.findViewById(R.id.updated_at);
        statusTxt = view.findViewById(R.id.status);
        tempTxt = view.findViewById(R.id.temp);
        temp_minTxt = view.findViewById(R.id.temp_min);
        temp_maxTxt = view.findViewById(R.id.temp_max);
        sunriseTxt = view.findViewById(R.id.sunrise);
        sunsetTxt = view.findViewById(R.id.sunset);
        windTxt = view.findViewById(R.id.wind);
        pressureTxt = view.findViewById(R.id.pressure);
        humidityTxt = view.findViewById(R.id.humidity);
        progressBar = view.findViewById(R.id.loader);
        mainContainer = view.findViewById(R.id.mainContainer);
        errorText  = view.findViewById(R.id.errorText);
        day1temp = view.findViewById(R.id.Day1Temp);
        day2temp = view.findViewById(R.id.Day2Temp);
        day3temp = view.findViewById(R.id.Day3Temp);
        day4temp = view.findViewById(R.id.Day4Temp);
        day5temp = view.findViewById(R.id.Day5Temp);

        day1value= view.findViewById(R.id.Day1Value);
        day2value= view.findViewById(R.id.Day2Value);
        day3value= view.findViewById(R.id.Day3Value);
        day4value= view.findViewById(R.id.Day4Value);
        day5value= view.findViewById(R.id.Day5Value);


        new weatherTask().execute();
        return view;
    }

    class weatherTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            /* Showing the ProgressBar, Making the main design GONE */
            progressBar.setVisibility(View.VISIBLE);
            mainContainer.setVisibility(View.GONE);
            errorText.setVisibility(View.GONE);
        }

        protected String doInBackground(String... args) {
            String response = HttpRequest.excuteGet("https://api.openweathermap.org/data/2.5/weather?q=" + CITY + "&units=metric&appid=" + API);

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








                /* Populating extracted data into our views */
                addressTxt.setText(address);
                updated_atTxt.setText(updatedAtText);
                statusTxt.setText(weatherDescription.toUpperCase());
                tempTxt.setText(temp);
                temp_minTxt.setText(tempMin);
                temp_maxTxt.setText(tempMax);
                sunriseTxt.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunrise * 1000)));
                sunsetTxt.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunset * 1000)));
                windTxt.setText(windSpeed);
                pressureTxt.setText(pressure);
                humidityTxt.setText(humidity);

                /* Views populated, Hiding the loader, Showing the main design */
                getView().findViewById(R.id.loader).setVisibility(View.GONE);
                getView().findViewById(R.id.mainContainer).setVisibility(View.VISIBLE);



            }
            catch (JSONException e) {
                getView().findViewById(R.id.loader).setVisibility(View.GONE);
                getView().findViewById(R.id.errorText).setVisibility(View.VISIBLE);
            }

        }

    }

    public String loadJSONFromAsset() {
        String apiUrl = "http://api.openweathermap.org/data/2.5/forecast?q="+ CITY + "&APPID="+ API +"&units=metric";


        return apiUrl;
    }


    private String convertTimeToDay(String time){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:SSSS", Locale.getDefault());
        String days = "";
        try {
            Date date = format.parse(time);
            System.out.println("Our time " + date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            days = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault());
            System.out.println("Our time " + days);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }
}

