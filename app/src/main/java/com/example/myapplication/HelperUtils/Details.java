package com.example.myapplication.HelperUtils;

import java.io.Serializable;
import java.util.List;


@SuppressWarnings("serial")
public class Details   implements Serializable {

    private List<Flights> details = null;

    public List<Flights> getDetails() {
        return details;
    }

    public void setDetails(List<Flights> details) {
        this.details = details;
    }
}



