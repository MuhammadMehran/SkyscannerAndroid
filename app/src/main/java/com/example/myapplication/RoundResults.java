package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.HelperUtils.Details;
import com.example.myapplication.HelperUtils.ResultAdapter;
import com.example.myapplication.HelperUtils.RoundDetails;
import com.example.myapplication.HelperUtils.RoundResultAdapter;

public class RoundResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_results);

        String title = getIntent().getStringExtra("From");
        title += " - " + getIntent().getStringExtra("To");
        setTitle(title);


        RoundDetails details = (RoundDetails) getIntent().getSerializableExtra("Details");

        int size = details.getDetails().size();

        if (size == 0){
            Toast.makeText(this, "Sorry No Flights Found", Toast.LENGTH_LONG).show();
            startActivity(new Intent(RoundResults.this,Main3Activity.class));
        }


        String[] out_airline_images = new String[size];
        String[] out_durations = new String[size];
        String[] in_airline_images = new String[size];
        String[] in_durations = new String[size];
        String[] prices = new String[size];


        for (int i=0;i<size;i++){
            out_airline_images[i] = details.getDetails().get(i).getOutboundCarriersImg();
            out_durations[i] = details.getDetails().get(i).getOutDeparture().split("T")[1];
            out_durations[i] += " - " + details.getDetails().get(i).getOutArrival().split("T")[1];
            in_airline_images[i] = details.getDetails().get(i).getInboundCarriersImg();
            in_durations[i] = details.getDetails().get(i).getInDeparture().split("T")[1];
            in_durations[i] += " - " + details.getDetails().get(i).getInArrival().split("T")[1];


            try {
                prices[i] = "RS. "+ details.getDetails().get(i).getPrice().toString();
            }catch (Exception e){
                prices[i] = "Not Available";
            }

        }
        RoundResultAdapter resultAdapter = new RoundResultAdapter(
                RoundResults.this,
                R.layout.round_result,
                out_airline_images,
                out_durations,
                in_airline_images,
                in_durations,
                prices
        );

        ListView listView = findViewById(R.id.RoundResultListView);
        listView.setAdapter(resultAdapter);

    }
}
