package com.example.myapplication.HelperUtils;

public class FlightQuery {
    private String originPlace;
    private String destinationPlace;
    private String cabinClass;
    private String children;
    private String country;
    private String currency;
    private String outboundDate;
    private String infants;
    private String adults;
    private String inboundDate;

    public FlightQuery(String originPlace, String destinationPlace, String cabinClass, String children, String country, String currency, String outboundDate, String adults, String inboundDate, String infants) {
        this.originPlace = originPlace;
        this.infants = infants;
        this.destinationPlace = destinationPlace;
        this.cabinClass = cabinClass;
        this.children = children;
        this.country = country;
        this.currency = currency;
        this.outboundDate = outboundDate;
        this.adults = adults;
        this.inboundDate = inboundDate;
    }



    public String getOriginPlace() {
        return originPlace;
    }

    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
    }

    public String getDestinationPlace() {
        return destinationPlace;
    }

    public void setDestinationPlace(String destinationPlace) {
        this.destinationPlace = destinationPlace;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(String outboundDate) {
        this.outboundDate = outboundDate;
    }

    public String getAdults() {
        return adults;
    }

    public void setAdults(String adults) {
        this.adults = adults;
    }

    public String getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(String inboundDate) {
        this.inboundDate = inboundDate;
    }

    public String getInfants() {
        return infants;
    }

    public void setInfants(String infants) {
        this.infants = infants;
    }
}
