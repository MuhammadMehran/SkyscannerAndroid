package com.example.myapplication.fragments;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.HelperUtils.Details;
import com.example.myapplication.HelperUtils.FlightQuery;
import com.example.myapplication.HelperUtils.HelperUtilities;
import com.example.myapplication.HelperUtils.RetrofitClient;
import com.example.myapplication.Main2Activity;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OneWayFragment extends Fragment {



    //date picker dialog
    private DatePickerDialog datePickerDialog1;
    private DatePickerDialog datePickerDialog2;
    private DatePickerDialog datePickerDialog3;

    //current date
    private int year;
    private int month;
    private int day;

    //id of date picker controls
    private final int ONE_WAY_DEPARTURE_DATE_PICKER = R.id.btnOneWayDepartureDatePicker;

    //traveller count
    private int oneWayTravellerCount = 1;
    private int oneWayTravellerCountInfant = 0;

    private int oneWayTravellerCountChild = 0;

    //traveller count view
    private TextView numTraveller;

    //add and remove image button controls in the dialog
    private ImageButton imgBtnAdd;
    private ImageButton imgBtnRemove;

    private TextView numTravellerChild;

    private TextView numTravellerInfant;

    //add and remove image button controls in the dialog
    private ImageButton imgBtnAddInfant;
    private ImageButton imgBtnRemoveInfant;

    private TextView numTravellerChildInfant;

    //add and remove image button controls in the dialog
    private ImageButton imgBtnAddChild;
    private ImageButton imgBtnRemoveChild;

    //custom dialog view
    private View dialogLayout;

    //one way UI controls
    private AutoCompleteTextView txtOneWayFrom;
    private AutoCompleteTextView txtOneWayTo;
    private Button btnOneWayDepartureDatePicker;
    private Button btnOneWayClass;
    private Button btnOneWayNumTraveller;

    private Button btnoneWayNumTravellerChild;
    private Button btnoneWayNumTravellerInfant;
    //search button
    private Button btnSearch;

    private int tempOneWaySelectedClassID = 0;
    private String oneWayDepartureDate, roundDepartureDate, roundReturnDate;
    private View header;
    private ImageView imgProfile;
    private int clientID;
    private int tempYear;
    private int tempMonth;
    private int tempDay;

    private boolean isValidOneWayDate = true;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main3,container,false);


        String[] CITIES = new String[] {
                "Toronto", "Ottawa", "Edmonton", "Winnipeg", "Victoria",
                "Fredericton", "St. John's", "Halifax", "Charlottetown",
                "Quebec City", "Regina", "Yellowknife", "Iqaluit", "Whitehorse", "New York", "Boston", "Los Angeles",
                "Montreal", "Lahore", "Islamabad", "Karachi", "Los Angles", "San Francisco", "New York", "Dubai"
        };


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_dropdown_item_1line, CITIES);



        //one way form
        txtOneWayFrom = (AutoCompleteTextView) view.findViewById(R.id.txtOneWayFrom);
        txtOneWayFrom.setAdapter(adapter);

        txtOneWayTo = (AutoCompleteTextView) view.findViewById(R.id.txtOneWayTo);
        txtOneWayTo.setAdapter(adapter);

        btnOneWayDepartureDatePicker = (Button) view.findViewById(R.id.btnOneWayDepartureDatePicker);
        btnOneWayClass = (Button) view.findViewById(R.id.btnOneWayClass);
        btnOneWayNumTraveller = (Button) view.findViewById(R.id.btnOneWayTraveller);

        //one way form
        txtOneWayFrom = (AutoCompleteTextView) view.findViewById(R.id.txtOneWayFrom);
        txtOneWayFrom.setAdapter(adapter);

        txtOneWayTo = (AutoCompleteTextView) view.findViewById(R.id.txtOneWayTo);
        txtOneWayTo.setAdapter(adapter);

        btnOneWayDepartureDatePicker = (Button) view.findViewById(R.id.btnOneWayDepartureDatePicker);
        btnOneWayClass = (Button) view.findViewById(R.id.btnOneWayClass);
        btnOneWayNumTraveller = (Button) view.findViewById(R.id.btnOneWayTraveller);


        btnoneWayNumTravellerChild = (Button)view.findViewById(R.id.btnOneWayTravellerChild);
        btnoneWayNumTravellerInfant = (Button) view.findViewById(R.id.btnOneWayTravellerInfant);




        year = HelperUtilities.currentYear();
        month = HelperUtilities.currentMonth();
        day = HelperUtilities.currentDay();



        //one way departure date picker on click listener
        btnOneWayDepartureDatePicker.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                datePickerDialog(ONE_WAY_DEPARTURE_DATE_PICKER).show();

            }
        });




        //one way class selector on click listener
        btnOneWayClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oneWayClassPickerDialog().show();
            }
        });

        //one way number of travellers on click listener
        btnOneWayNumTraveller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                oneWayNumTravellerDialog().show();
            }
        });




        btnoneWayNumTravellerChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                roundNumTravellerDialogChild().show();
            }
        });

        btnoneWayNumTravellerChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                roundNumTravellerDialogInfant().show();
            }
        });




        btnSearch = view.findViewById(R.id.btnSearchOneWay);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequest();
            }
        });


        return view;



    }


    //one way class picker dialog
    public Dialog oneWayClassPickerDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        final CharSequence[] classList = {"Economy", "Business", "Premium Economy", "First Class"}; //temp data, should be retrieved from database


        builder.setTitle("Select Class")
                .setSingleChoiceItems(classList, tempOneWaySelectedClassID, new DialogInterface
                        .OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        tempOneWaySelectedClassID = id;
                        //get selected class here
                        btnOneWayClass.setText(classList[id].toString());


                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        btnOneWayClass.setText(classList[tempOneWaySelectedClassID].toString());


        return builder.create();
    }




    //number of travellers dialog (one way)
    public Dialog oneWayNumTravellerDialog() {


        dialogLayout = getLayoutInflater().inflate(R.layout.custom_dialog_adults, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle("Number of travellers")
                .setView(dialogLayout)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //get number of traveller here
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        imgBtnRemove = (ImageButton) dialogLayout.findViewById(R.id.imgBtnRemove);
        imgBtnAdd = (ImageButton) dialogLayout.findViewById(R.id.imgBtnAdd);
        numTraveller = (TextView) dialogLayout.findViewById(R.id.txtNumber);

        imgBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oneWayTravellerCount++;
                numTraveller.setText(String.valueOf(oneWayTravellerCount));
                btnOneWayNumTraveller.setText(String.valueOf(oneWayTravellerCount) + " Traveller");
            }
        });

        imgBtnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (oneWayTravellerCount > 1) {
                    oneWayTravellerCount--;
                }
                numTraveller.setText(String.valueOf(oneWayTravellerCount));
                btnOneWayNumTraveller.setText(String.valueOf(oneWayTravellerCount) + " Traveller");
            }
        });


        numTraveller.setText(String.valueOf(oneWayTravellerCount));

        return builder.create();
    }


    public Dialog roundNumTravellerDialogChild() {

        dialogLayout = getLayoutInflater().inflate(R.layout.custom_dialog_childs, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle("Number of Child travellers")
                .setView(dialogLayout)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //get number of traveller here
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        imgBtnRemoveChild = (ImageButton) dialogLayout.findViewById(R.id.imgBtnRemoveChild);
        imgBtnAddChild = (ImageButton) dialogLayout.findViewById(R.id.imgBtnAddChild);
        numTravellerChild = (TextView) dialogLayout.findViewById(R.id.txtNumberChild);

        imgBtnAddChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oneWayTravellerCountChild++;
                numTravellerChild.setText(String.valueOf(oneWayTravellerCountChild));
                btnoneWayNumTravellerChild.setText(String.valueOf(oneWayTravellerCountChild) + " Children");
            }
        });

        imgBtnRemoveChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (oneWayTravellerCountChild > 0) {
                    oneWayTravellerCountChild--;
                }
                numTravellerChild.setText(String.valueOf(oneWayTravellerCountChild));
                btnoneWayNumTravellerChild.setText(String.valueOf(oneWayTravellerCountChild) + " Children");
            }
        });

        numTravellerChild.setText(String.valueOf(oneWayTravellerCountChild));

        return builder.create();
    }

    public Dialog roundNumTravellerDialogInfant() {

        dialogLayout = getLayoutInflater().inflate(R.layout.custom_dialog_infants, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle("Number of Infants")
                .setView(dialogLayout)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //get number of traveller here
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        imgBtnRemoveInfant = (ImageButton) dialogLayout.findViewById(R.id.imgBtnRemoveInfant);
        imgBtnAddInfant = (ImageButton) dialogLayout.findViewById(R.id.imgBtnAddInfant);
        numTravellerInfant = (TextView) dialogLayout.findViewById(R.id.txtNumberInfant);

        imgBtnAddInfant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oneWayTravellerCountInfant++;
                numTravellerInfant.setText(String.valueOf(oneWayTravellerCountInfant));
                btnoneWayNumTravellerInfant.setText(String.valueOf(oneWayTravellerCountInfant) + " Infants");
            }
        });

        imgBtnRemoveInfant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (oneWayTravellerCountInfant > 0) {
                    oneWayTravellerCountInfant--;
                }
                numTravellerInfant.setText(String.valueOf(oneWayTravellerCountInfant));
                btnoneWayNumTravellerInfant.setText(String.valueOf(oneWayTravellerCountInfant) + " Infants");
            }
        });

        numTravellerInfant.setText(String.valueOf(oneWayTravellerCountInfant));

        return builder.create();
    }


    public DatePickerDialog datePickerDialog(int datePickerId) {

        switch (datePickerId) {
            case ONE_WAY_DEPARTURE_DATE_PICKER:

                if (datePickerDialog1 == null) {
                    datePickerDialog1 = new DatePickerDialog(getContext(), getOneWayDepartureDatePickerListener(), year, month, day);
                }
                datePickerDialog1.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                return datePickerDialog1;


        }
        return null;
    }

    public DatePickerDialog.OnDateSetListener getOneWayDepartureDatePickerListener() {
        return new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int startYear, int startMonth, int startDay) {

                //get one way departure date here

                oneWayDepartureDate = startYear + "-" + (startMonth + 1) + "-" + startDay;
                btnOneWayDepartureDatePicker.setText(HelperUtilities.formatDate(startYear, startMonth, startDay));

            }
        };
    }

    public DatePickerDialog.OnDateSetListener getRoundDepartureDatePickerListener() {
        return new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int startYear, int startMonth, int startDay) {

                tempYear = startYear;
                tempMonth = startMonth;
                tempDay = startDay;

                //get round trip departure date here
                roundDepartureDate = startYear + "-" + (startMonth + 1) + "-" + startDay;
                btnOneWayDepartureDatePicker.setText(HelperUtilities.formatDate(startYear, startMonth, startDay));
            }
        };
    }



    public Dialog datePickerAlert() {
        return new AlertDialog.Builder(getContext())
                .setMessage("Please select a valid return date. The return date cannot be before the departure date.")
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                }).create();
    }

    public Dialog datePickerOneAlert() {
        return new AlertDialog.Builder(getContext())
                .setMessage("Please select a departure date.")
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                }).create();
    }

    public Dialog datePickerTwoAlert() {
        return new AlertDialog.Builder(getContext())
                .setMessage("Please select a return date.")
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                }).create();
    }


    public void sendRequest() {

        String msg = "";
        msg += "ORIGIN" + txtOneWayFrom.getText().toString().trim() + "\n";
        msg += "DESTINATION" + txtOneWayTo.getText().toString().trim() + "\n";
        msg += "DEPARTURE_DATE" + oneWayDepartureDate + "\n";
        msg += "FLIGHT_CLASS" +  btnOneWayClass.getText().toString() + "\n";
        msg += "ROUND_NUM_TRAVELLER" + oneWayTravellerCount + "\n";
        msg += "ROUND_NUM_TRAVELLER_CHILDREN" + oneWayTravellerCountChild + "\n";
        msg += "ROUND_NUM_TRAVELLER_INFANTS" + oneWayTravellerCountInfant + "\n";



        Toast.makeText(getContext(),msg ,Toast.LENGTH_LONG).show();


//
        final ProgressDialog progress=new ProgressDialog(getContext());
        progress.setMessage("Feteching Flights");
//        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(true);
        progress.setProgress(0);
        progress.show();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .build();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_url))
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        RetrofitClient client = retrofit.create(RetrofitClient.class);

        FlightQuery flightQuery = new FlightQuery(
                txtOneWayFrom.getText().toString().trim(),
                txtOneWayTo.getText().toString().trim(),
                btnOneWayClass.getText().toString(),
                String.valueOf(oneWayTravellerCountChild),
                "PK",
                "PKR",
                oneWayDepartureDate,
                String.valueOf(oneWayTravellerCount),
                roundReturnDate,
                String.valueOf(oneWayTravellerCountInfant)
        );
        Call<Details> call = client.FindPrices(flightQuery);
        call.enqueue(new retrofit2.Callback<Details>() {
            @Override
            public void onResponse(Call<Details> call, retrofit2.Response<Details> response) {
                progress.cancel();
                if(response.body() != null){
                    Details details = response.body();
//                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), Main2Activity.class);
                    intent.putExtra("Details", response.body());
                    intent.putExtra("From",txtOneWayFrom.getText().toString().trim());
                    intent.putExtra("To",txtOneWayTo.getText().toString().trim());
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Details> call, Throwable t) {
                progress.cancel();
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
