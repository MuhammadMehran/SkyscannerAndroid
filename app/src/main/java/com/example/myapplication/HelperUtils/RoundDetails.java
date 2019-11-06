package com.example.myapplication.HelperUtils;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class RoundDetails implements Serializable {
    private List<RoundFlights> details = null;

    public List<RoundFlights> getDetails() {
        return details;
    }

    public void setDetails(List<RoundFlights> details) {
        this.details = details;
    }
}
