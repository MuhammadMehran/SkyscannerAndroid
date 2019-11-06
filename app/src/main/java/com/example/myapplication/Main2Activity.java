package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.HelperUtils.Details;
import com.example.myapplication.HelperUtils.ResultAdapter;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        String title = getIntent().getStringExtra("From");
        title += " - " + getIntent().getStringExtra("To");
        setTitle(title);

        Details details = (Details) getIntent().getSerializableExtra("Details");

        int size = details.getDetails().size();

        if (size == 0){
            Toast.makeText(this, "Sorry No Flights Found", Toast.LENGTH_LONG).show();
            startActivity(new Intent(Main2Activity.this,Main3Activity.class));
        }


        String[] airline_images = new String[size];
        String[] airlines = new String[size];
        String[] durations = new String[size];
        String[] prices = new String[size];


        for (int i=0;i<size;i++){
            airline_images[i] = details.getDetails().get(i).getCarriersImgLink();
            airlines[i] = details.getDetails().get(i).getCarriersName();
            durations[i] = details.getDetails().get(i).getDeparture().split("T")[1];
            durations[i] += " - " + details.getDetails().get(i).getArrival().split("T")[1];


            try {
                prices[i] = "RS. "+ details.getDetails().get(i).getPrice().toString();
            }catch (Exception e){
                prices[i] = "Not Available";
            }

        }
        ResultAdapter resultAdapter = new ResultAdapter(
                Main2Activity.this,
                R.layout.result,
                airline_images,
                durations,
                airlines,
                prices
        );

        ListView listView = findViewById(R.id.ResultListView);
        listView.setAdapter(resultAdapter);


     }
}
