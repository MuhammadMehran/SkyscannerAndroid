package com.example.myapplication.HelperUtils;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitClient {

    @POST("find_prices")
    Call<Details> FindPrices(@Body FlightQuery flightQuery);

    @POST("find_prices_round")
    Call<RoundDetails> FindRoundPrices(@Body FlightQuery flightQuery);
}
