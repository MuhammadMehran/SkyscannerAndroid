package com.example.myapplication.HelperUtils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

public class RoundResultAdapter extends ArrayAdapter<String> {


    private Context context;
    private  String[] out_airline_images;
    private  String[] out_durations;
    private  String[] in_airline_images;
    private  String[] in_durations;
    private  String[] prices;


    public RoundResultAdapter(Context context,
                         int layoutToBeInflated,
                         String[] out_airline_images,
                         String[] out_durations,
                         String[] in_airline_images,
                         String[] in_durations,
                         String[] prices) {
        super(context, R.layout.round_result, prices);
        this.context = context;
        this.out_airline_images = out_airline_images;
        this.out_durations = out_durations;
        this.in_airline_images = in_airline_images;
        this.in_durations = in_durations;
        this.prices = prices;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater(); //inflate row template having: icon + vertical-LinearLayout holding label1 and label2
        View row = inflater.inflate(R.layout.round_result, null);

        TextView out_duration =  row.findViewById(R.id.out_duration);
        TextView in_duration =  row.findViewById(R.id.in_duration);
        TextView price =  row.findViewById(R.id.round_price);
        ImageView out_airline_image = row.findViewById(R.id.out_airline_image);
        ImageView in_airline_image = row.findViewById(R.id.in_airline_image);

        out_duration.setText(out_durations[position]);
        in_duration.setText(in_durations[position]);
        price.setText(prices[position]);
        Picasso.with(context).load(out_airline_images[position]).into(out_airline_image);
        Picasso.with(context).load(in_airline_images[position]).into(in_airline_image);
        return row;
    }

}
