package com.example.myapplication.HelperUtils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ResultAdapter extends ArrayAdapter<String> {


    private  Context context;
    private  String[] airline_images;
    private  String[] durations;
    private  String[] airlines;
    private  String[] prices;

    public ResultAdapter(Context context,
                             int layoutToBeInflated,
                             String[] airline_images,
                             String[] durations,
                             String[] airlines,
                             String[] prices){
        super(context, R.layout.result,prices);
        this.context = context;
        this.airline_images = airline_images;
        this.durations = durations;
        this.airlines = airlines;
        this.prices = prices;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater(); //inflate row template having: icon + vertical-LinearLayout holding label1 and label2
        View row = inflater.inflate(R.layout.result, null);

        TextView duration =  row.findViewById(R.id.duration);
        TextView airline =  row.findViewById(R.id.airline);
        TextView price =  row.findViewById(R.id.price);
        ImageView airline_image = row.findViewById(R.id.airline_image);

        duration.setText(durations[position]);
        airline.setText(airlines[position]);
        price.setText(prices[position]);
        Picasso.with(context).load(airline_images[position]).into(airline_image);


        return row;
    }
}
