package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.HelperUtils.Details;
import com.example.myapplication.HelperUtils.FlightQuery;
import com.example.myapplication.HelperUtils.Flights;
import com.example.myapplication.HelperUtils.HelperUtilities;
import com.example.myapplication.HelperUtils.RetrofitClient;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


//    //date picker dialog
//    private DatePickerDialog datePickerDialog1;
//    private DatePickerDialog datePickerDialog2;
//    private DatePickerDialog datePickerDialog3;
//
//    //current date
//    private int year;
//    private int month;
//    private int day;
//
//    //id of date picker controls
//    private final int ONE_WAY_DEPARTURE_DATE_PICKER = R.id.btnOneWayDepartureDatePicker;
//    private final int ROUND_DEPARTURE_DATE_PICKER = R.id.btnRoundDepartureDatePicker;
//    private final int ROUND_RETURN_DATE_PICKER = R.id.btnRoundReturnDatePicker;
//
//    //traveller count
//    private int oneWayTravellerCount = 1;
//    private int roundTravellerCount = 1;
//    private int roundTravellerCountInfant = 0;
//
//    private int roundTravellerCountChild = 0;
//
//    //traveller count view
//    private TextView numTraveller;
//
//    //add and remove image button controls in the dialog
//    private ImageButton imgBtnAdd;
//    private ImageButton imgBtnRemove;
//
//    private TextView numTravellerChild;
//
//    private TextView numTravellerInfant;
//
//    //add and remove image button controls in the dialog
//    private ImageButton imgBtnAddInfant;
//    private ImageButton imgBtnRemoveInfant;
//
//    private TextView numTravellerChildInfant;
//
//    //add and remove image button controls in the dialog
//    private ImageButton imgBtnAddChild;
//    private ImageButton imgBtnRemoveChild;
//
//    //custom dialog view
//    private View dialogLayout;
//
//    //one way UI controls
//    private AutoCompleteTextView txtOneWayFrom;
//    private AutoCompleteTextView txtOneWayTo;
//    private Button btnOneWayDepartureDatePicker;
//    private Button btnOneWayClass;
//    private Button btnOneWayNumTraveller;
//
//    //round trip UI controls
//    private AutoCompleteTextView txtRoundFrom;
//    private AutoCompleteTextView txtRoundTo;
//    private Button btnRoundDepartureDatePicker;
//    private Button btnRoundReturnDatePicker;
//    private Button btnRoundClass;
//    private Button btnRoundNumTraveller;
//    private Button btnRoundNumTravellerChild;
//    private Button btnRoundNumTravellerInfant;
//    //search button
//    private Button btnSearch;
//
//    private int tempOneWaySelectedClassID = 0;
//    private int tempRoundSelectedClassID = 0;
//    private String oneWayDepartureDate, roundDepartureDate, roundReturnDate;
//    private View header;
//    private ImageView imgProfile;
//    private int clientID;
//    private int tempYear;
//    private int tempMonth;
//    private int tempDay;
//
//    private boolean isValidOneWayDate = true;
//    private boolean isValidRoundDate = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        String[] CITIES = new String[] {
//                "Toronto", "Ottawa", "Edmonton", "Winnipeg", "Victoria",
//                "Fredericton", "St. John's", "Halifax", "Charlottetown",
//                "Quebec City", "Regina", "Yellowknife", "Iqaluit", "Whitehorse", "New York", "Boston", "Los Angeles",
//                "Montreal", "Lahore", "Islamabad", "Karachi", "Los Angles", "San Francisco", "New York"
//        };
//
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_dropdown_item_1line, CITIES);
//
//        //one way form
//        txtOneWayFrom = (AutoCompleteTextView) findViewById(R.id.txtOneWayFrom);
//        txtOneWayFrom.setAdapter(adapter);
//
//        txtOneWayTo = (AutoCompleteTextView) findViewById(R.id.txtOneWayTo);
//        txtOneWayTo.setAdapter(adapter);
//
//        btnOneWayDepartureDatePicker = (Button) findViewById(R.id.btnOneWayDepartureDatePicker);
//        btnOneWayClass = (Button) findViewById(R.id.btnOneWayClass);
//        btnOneWayNumTraveller = (Button) findViewById(R.id.btnOneWayNumTraveller);
//
//        //one way form
//        txtOneWayFrom = (AutoCompleteTextView) findViewById(R.id.txtOneWayFrom);
//        txtOneWayFrom.setAdapter(adapter);
//
//        txtOneWayTo = (AutoCompleteTextView) findViewById(R.id.txtOneWayTo);
//        txtOneWayTo.setAdapter(adapter);
//
//        btnOneWayDepartureDatePicker = (Button) findViewById(R.id.btnOneWayDepartureDatePicker);
//        btnOneWayClass = (Button) findViewById(R.id.btnOneWayClass);
//        btnOneWayNumTraveller = (Button) findViewById(R.id.btnOneWayNumTraveller);
//
//
//        //round trip form
//        txtRoundFrom = (AutoCompleteTextView) findViewById(R.id.txtRoundFrom);
//        txtRoundFrom.setAdapter(adapter);
//        txtRoundTo = (AutoCompleteTextView) findViewById(R.id.txtRoundTo);
//        txtRoundTo.setAdapter(adapter);
//        btnRoundDepartureDatePicker = (Button) findViewById(R.id.btnRoundDepartureDatePicker);
//        btnRoundReturnDatePicker = (Button) findViewById(R.id.btnRoundReturnDatePicker);
//        btnRoundClass = (Button) findViewById(R.id.btnRoundClass);
//        btnRoundNumTraveller = (Button) findViewById(R.id.btnRoundTraveller);
//        btnRoundNumTravellerChild = (Button) findViewById(R.id.btnRoundTravellerChild);
//        btnRoundNumTravellerInfant = (Button) findViewById(R.id.btnRoundTravellerInfant);
//
//
//        btnSearch = (Button) findViewById(R.id.btnSearch);
//
//
//        year = HelperUtilities.currentYear();
//        month = HelperUtilities.currentMonth();
//        day = HelperUtilities.currentDay();
//
//
//
//        //one way departure date picker on click listener
//        btnOneWayDepartureDatePicker.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                datePickerDialog(ONE_WAY_DEPARTURE_DATE_PICKER).show();
//
//            }
//        });
//
//        //round trip departure date picker on click listener
//        btnRoundDepartureDatePicker.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                datePickerDialog(ROUND_DEPARTURE_DATE_PICKER).show();
//            }
//        });
//
//        //round trip return date picker on click listener
//        btnRoundReturnDatePicker.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                datePickerDialog(ROUND_RETURN_DATE_PICKER).show();
//            }
//        });
//
//
//        //one way class selector on click listener
//        btnOneWayClass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                oneWayClassPickerDialog().show();
//            }
//        });
//
//        //one way number of travellers on click listener
//        btnOneWayNumTraveller.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                oneWayNumTravellerDialog().show();
//            }
//        });
//
//        //round trip class selector on click listener
//        btnRoundClass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                roundClassPickerDialog().show();
//            }
//        });
//
//        // round trip number of traveller on click listener
//        btnRoundNumTraveller.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                roundNumTravellerDialog().show();
//            }
//        });
//
//        btnRoundNumTravellerChild.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                roundNumTravellerDialogChild().show();
//            }
//        });
//
//        btnRoundNumTravellerInfant.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                roundNumTravellerDialogInfant().show();
//            }
//        });
//
//
//        //searches available flights on click
//        btnSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String msg = "";
//                msg += "ORIGIN" + txtRoundFrom.getText().toString().trim() + "\n";
//                msg += "DESTINATION" + txtRoundTo.getText().toString().trim() + "\n";
//                msg += "DEPARTURE_DATE" + roundDepartureDate + "\n";
//                msg += "RETURN_DATE" + roundReturnDate + "\n";
//                msg += "FLIGHT_CLASS" +  btnOneWayClass.getText().toString() + "\n";
//                msg += "ROUND_NUM_TRAVELLER" + roundTravellerCount + "\n";
//                msg += "ROUND_NUM_TRAVELLER_CHILDREN" + roundTravellerCountChild + "\n";
//                msg += "ROUND_NUM_TRAVELLER_INFANTS" + roundTravellerCountInfant + "\n";
//
//
//
////                Toast.makeText(getApplicationContext(),msg ,Toast.LENGTH_LONG).show();
//                sendRequest();
//
//            }
//        });
    }

//    //one way class picker dialog
//    public Dialog oneWayClassPickerDialog() {
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        final CharSequence[] classList = {"Economy", "Business", "Premium Economy", "First Class"}; //temp data, should be retrieved from database
//
//
//        builder.setTitle("Select Class")
//                .setSingleChoiceItems(classList, tempOneWaySelectedClassID, new DialogInterface
//                        .OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int id) {
//                        tempOneWaySelectedClassID = id;
//                        //get selected class here
//                        btnOneWayClass.setText(classList[id].toString());
//
//
//                    }
//                })
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//
//
//                    }
//                })
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//
//                    }
//                });
//
//        btnOneWayClass.setText(classList[tempOneWaySelectedClassID].toString());
//
//
//        return builder.create();
//    }
//
//
//    //round class picker dialog
//    public Dialog roundClassPickerDialog() {
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        final CharSequence[] classList = {"Economy", "Business", "Premium Economy", "First Class"}; //temp data, should be retrieved from database
//
//
//        builder.setTitle("Select Class")
//                .setSingleChoiceItems(classList, tempRoundSelectedClassID, new DialogInterface
//                        .OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int id) {
//                        tempRoundSelectedClassID = id;
//                        //get selected class here
//                        btnRoundClass.setText(classList[id].toString());
//
//
//                    }
//                })
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//
//
//                    }
//                })
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//
//                    }
//                });
//
//        btnRoundClass.setText(classList[tempRoundSelectedClassID].toString());
//
//
//        return builder.create();
//    }
//
//    //number of travellers dialog (one way)
//    public Dialog oneWayNumTravellerDialog() {
//
//
//        dialogLayout = getLayoutInflater().inflate(R.layout.custom_dialog_adults, null);
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//        builder.setTitle("Number of travellers")
//                .setView(dialogLayout)
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        //get number of traveller here
//                    }
//                })
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//
//                    }
//                });
//
//        imgBtnRemove = (ImageButton) dialogLayout.findViewById(R.id.imgBtnRemove);
//        imgBtnAdd = (ImageButton) dialogLayout.findViewById(R.id.imgBtnAdd);
//        numTraveller = (TextView) dialogLayout.findViewById(R.id.txtNumber);
//
//        imgBtnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                oneWayTravellerCount++;
//                numTraveller.setText(String.valueOf(oneWayTravellerCount));
//                btnOneWayNumTraveller.setText(String.valueOf(oneWayTravellerCount) + " Traveller");
//            }
//        });
//
//        imgBtnRemove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (oneWayTravellerCount > 1) {
//                    oneWayTravellerCount--;
//                }
//                numTraveller.setText(String.valueOf(oneWayTravellerCount));
//                btnOneWayNumTraveller.setText(String.valueOf(oneWayTravellerCount) + " Traveller");
//            }
//        });
//
//
//        numTraveller.setText(String.valueOf(oneWayTravellerCount));
//
//        return builder.create();
//    }
//
//    //number of travellers dialog (round trip)
//    public Dialog roundNumTravellerDialog() {
//
//        dialogLayout = getLayoutInflater().inflate(R.layout.custom_dialog_adults, null);
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//        builder.setTitle("Number of travellers")
//                .setView(dialogLayout)
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        //get number of traveller here
//                    }
//                })
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//
//                    }
//                });
//
//        imgBtnRemove = (ImageButton) dialogLayout.findViewById(R.id.imgBtnRemove);
//        imgBtnAdd = (ImageButton) dialogLayout.findViewById(R.id.imgBtnAdd);
//        numTraveller = (TextView) dialogLayout.findViewById(R.id.txtNumber);
//
//        imgBtnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                roundTravellerCount++;
//                numTraveller.setText(String.valueOf(roundTravellerCount));
//                btnRoundNumTraveller.setText(String.valueOf(roundTravellerCount) + " Traveller");
//            }
//        });
//
//        imgBtnRemove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (roundTravellerCount > 1) {
//                    roundTravellerCount--;
//                }
//                numTraveller.setText(String.valueOf(roundTravellerCount));
//                btnRoundNumTraveller.setText(String.valueOf(roundTravellerCount) + " Traveller");
//            }
//        });
//
//        numTraveller.setText(String.valueOf(roundTravellerCount));
//
//        return builder.create();
//    }
//    public Dialog roundNumTravellerDialogChild() {
//
//        dialogLayout = getLayoutInflater().inflate(R.layout.custom_dialog_childs, null);
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//        builder.setTitle("Number of Child travellers")
//                .setView(dialogLayout)
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        //get number of traveller here
//                    }
//                })
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//
//                    }
//                });
//
//        imgBtnRemoveChild = (ImageButton) dialogLayout.findViewById(R.id.imgBtnRemoveChild);
//        imgBtnAddChild = (ImageButton) dialogLayout.findViewById(R.id.imgBtnAddChild);
//        numTravellerChild = (TextView) dialogLayout.findViewById(R.id.txtNumberChild);
//
//        imgBtnAddChild.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                roundTravellerCountChild++;
//                numTravellerChild.setText(String.valueOf(roundTravellerCountChild));
//                btnRoundNumTravellerChild.setText(String.valueOf(roundTravellerCountChild) + " Children");
//            }
//        });
//
//        imgBtnRemoveChild.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (roundTravellerCountChild > 0) {
//                    roundTravellerCountChild--;
//                }
//                numTravellerChild.setText(String.valueOf(roundTravellerCountChild));
//                btnRoundNumTravellerChild.setText(String.valueOf(roundTravellerCountChild) + " Children");
//            }
//        });
//
//        numTravellerChild.setText(String.valueOf(roundTravellerCountChild));
//
//        return builder.create();
//    }
//
//    public Dialog roundNumTravellerDialogInfant() {
//
//        dialogLayout = getLayoutInflater().inflate(R.layout.custom_dialog_infants, null);
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//        builder.setTitle("Number of Infants")
//                .setView(dialogLayout)
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        //get number of traveller here
//                    }
//                })
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//
//                    }
//                });
//
//        imgBtnRemoveInfant = (ImageButton) dialogLayout.findViewById(R.id.imgBtnRemoveInfant);
//        imgBtnAddInfant = (ImageButton) dialogLayout.findViewById(R.id.imgBtnAddInfant);
//        numTravellerInfant = (TextView) dialogLayout.findViewById(R.id.txtNumberInfant);
//
//        imgBtnAddInfant.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                roundTravellerCountInfant++;
//                numTravellerInfant.setText(String.valueOf(roundTravellerCountInfant));
//                btnRoundNumTravellerInfant.setText(String.valueOf(roundTravellerCountInfant) + " Infants");
//            }
//        });
//
//        imgBtnRemoveInfant.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (roundTravellerCountInfant > 0) {
//                    roundTravellerCountInfant--;
//                }
//                numTravellerInfant.setText(String.valueOf(roundTravellerCountInfant));
//                btnRoundNumTravellerInfant.setText(String.valueOf(roundTravellerCountInfant) + " Infants");
//            }
//        });
//
//        numTravellerInfant.setText(String.valueOf(roundTravellerCountInfant));
//
//        return builder.create();
//    }
//
//
//    public DatePickerDialog datePickerDialog(int datePickerId) {
//
//        switch (datePickerId) {
//            case ONE_WAY_DEPARTURE_DATE_PICKER:
//
//                if (datePickerDialog1 == null) {
//                    datePickerDialog1 = new DatePickerDialog(this, getOneWayDepartureDatePickerListener(), year, month, day);
//                }
//                datePickerDialog1.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
//                return datePickerDialog1;
//
//            case ROUND_DEPARTURE_DATE_PICKER:
//
//                if (datePickerDialog2 == null) {
//                    datePickerDialog2 = new DatePickerDialog(this, getRoundDepartureDatePickerListener(), year, month, day);
//                }
//                datePickerDialog2.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
//                return datePickerDialog2;
//
//            case ROUND_RETURN_DATE_PICKER:
//
//                if (datePickerDialog3 == null) {
//                    datePickerDialog3 = new DatePickerDialog(this, getRoundReturnDatePickerListener(), year, month, day);
//                }
//                datePickerDialog3.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
//                return datePickerDialog3;
//        }
//        return null;
//    }
//
//    public DatePickerDialog.OnDateSetListener getOneWayDepartureDatePickerListener() {
//        return new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int startYear, int startMonth, int startDay) {
//
//                //get one way departure date here
//
//                oneWayDepartureDate = startYear + "-" + (startMonth + 1) + "-" + startDay;
//                btnOneWayDepartureDatePicker.setText(HelperUtilities.formatDate(startYear, startMonth, startDay));
//
//            }
//        };
//    }
//
//    public DatePickerDialog.OnDateSetListener getRoundDepartureDatePickerListener() {
//        return new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int startYear, int startMonth, int startDay) {
//
//                tempYear = startYear;
//                tempMonth = startMonth;
//                tempDay = startDay;
//
//                //get round trip departure date here
//                roundDepartureDate = startYear + "-" + (startMonth + 1) + "-" + startDay;
//                btnRoundDepartureDatePicker.setText(HelperUtilities.formatDate(startYear, startMonth, startDay));
//            }
//        };
//    }
//
//    public DatePickerDialog.OnDateSetListener getRoundReturnDatePickerListener() {
//        return new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int startYear, int startMonth, int startDay) {
//
//                String departureDate = tempYear + "-" + (tempMonth + 1) + "-" + tempDay;
//                String returnDate = startYear + "-" + (startMonth + 1) + "-" + startDay;
//
//                if (HelperUtilities.compareDate(departureDate, returnDate)) {
//                    datePickerAlert().show();
//                    isValidRoundDate = false;
//                } else {
//                    isValidRoundDate = true;
//                    //get round trip return date here
//                    roundReturnDate = startYear + "-" + (startMonth + 1) + "-" + startDay;
//                    btnRoundReturnDatePicker.setText(HelperUtilities.formatDate(startYear, startMonth, startDay));
//                }
//            }
//        };
//    }
//
//    public Dialog datePickerAlert() {
//        return new AlertDialog.Builder(this)
//                .setMessage("Please select a valid return date. The return date cannot be before the departure date.")
//                .setCancelable(false)
//                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                    }
//                }).create();
//    }
//
//    public Dialog datePickerOneAlert() {
//        return new AlertDialog.Builder(this)
//                .setMessage("Please select a departure date.")
//                .setCancelable(false)
//                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                    }
//                }).create();
//    }
//
//    public Dialog datePickerTwoAlert() {
//        return new AlertDialog.Builder(this)
//                .setMessage("Please select a return date.")
//                .setCancelable(false)
//                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                    }
//                }).create();
//    }
//
//
//    public void sendRequest() {
//
//        final ProgressDialog progress=new ProgressDialog(MainActivity.this);
//        progress.setMessage("Feteching Flights");
////        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//        progress.setIndeterminate(true);
//        progress.setProgress(0);
//        progress.show();
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .connectTimeout(5, TimeUnit.MINUTES)
//                .readTimeout(5, TimeUnit.MINUTES)
//                .writeTimeout(5, TimeUnit.MINUTES)
//                .build();
//        Retrofit.Builder builder = new Retrofit.Builder()
//                .baseUrl("https://PlanYourFlight.pythonanywhere.com/")
//                .client(okHttpClient)
//                .addConverterFactory(GsonConverterFactory.create());
//        Retrofit retrofit = builder.build();
//        RetrofitClient client = retrofit.create(RetrofitClient.class);
//
//        FlightQuery flightQuery = new FlightQuery(
//                txtRoundFrom.getText().toString().trim(),
//                txtRoundTo.getText().toString().trim(),
//                btnRoundClass.getText().toString(),
//                String.valueOf(roundTravellerCountChild),
//                "PK",
//                "PKR",
//                roundDepartureDate,
//                String.valueOf(roundTravellerCount),
//                roundReturnDate,
//                String.valueOf(roundTravellerCountInfant)
//        );
//        Call<Details> call = client.FindPrices(flightQuery);
//        call.enqueue(new retrofit2.Callback<Details>() {
//            @Override
//            public void onResponse(Call<Details> call, retrofit2.Response<Details> response) {
//                progress.cancel();
//                if(response.body() != null){
//                    Details details = response.body();
////                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//                    intent.putExtra("Details", response.body());
//                    intent.putExtra("From",txtRoundFrom.getText().toString().trim());
//                    intent.putExtra("To",txtRoundTo.getText().toString().trim());
//                    startActivity(intent);
//                }
//                else{
//                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Details> call, Throwable t) {
//                progress.cancel();
//                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }




}
