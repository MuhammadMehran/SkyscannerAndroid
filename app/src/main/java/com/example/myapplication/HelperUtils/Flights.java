package com.example.myapplication.HelperUtils;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SuppressWarnings("serial")
public class Flights implements Serializable {
    private String Arrival;
    private List<Integer> Carriers = null;
    private String CarriersImgLink;
    private String CarriersName;
    private String Departure;
    private String Id;
    private Double Price;

    public String getArrival() {
        return Arrival;
    }

    public void setArrival(String arrival) {
        Arrival = arrival;
    }

    public List<Integer> getCarriers() {
        return Carriers;
    }

    public void setCarriers(List<Integer> carriers) {
        Carriers = carriers;
    }

    public String getCarriersImgLink() {
        return CarriersImgLink;
    }

    public void setCarriersImgLink(String carriersImgLink) {
        CarriersImgLink = carriersImgLink;
    }

    public String getCarriersName() {
        return CarriersName;
    }

    public void setCarriersName(String carriersName) {
        CarriersName = carriersName;
    }

    public String getDeparture() {
        return Departure;
    }

    public void setDeparture(String departure) {
        Departure = departure;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }





}
