package com.example.myapplication.HelperUtils;


import java.io.Serializable;

@SuppressWarnings("serial")
public class RoundFlights implements Serializable {

    private Integer deals;
    private String inArrival;
    private String inDeparture;
    private Integer inStops;
    private String inboundCarriers;
    private String inboundCarriersImg;
    private String inboundLegId;
    private String outArrival;
    private String outDeparture;
    private Integer outStops;
    private String outboundCarriers;
    private String outboundCarriersImg;
    private String outboundLegId;
    private Double price;

    public Integer getDeals() {
        return deals;
    }

    public void setDeals(Integer deals) {
        this.deals = deals;
    }

    public String getInArrival() {
        return inArrival;
    }

    public void setInArrival(String inArrival) {
        this.inArrival = inArrival;
    }

    public String getInDeparture() {
        return inDeparture;
    }

    public void setInDeparture(String inDeparture) {
        this.inDeparture = inDeparture;
    }

    public Integer getInStops() {
        return inStops;
    }

    public void setInStops(Integer inStops) {
        this.inStops = inStops;
    }

    public String getInboundCarriers() {
        return inboundCarriers;
    }

    public void setInboundCarriers(String inboundCarriers) {
        this.inboundCarriers = inboundCarriers;
    }

    public String getInboundCarriersImg() {
        return inboundCarriersImg;
    }

    public void setInboundCarriersImg(String inboundCarriersImg) {
        this.inboundCarriersImg = inboundCarriersImg;
    }

    public String getInboundLegId() {
        return inboundLegId;
    }

    public void setInboundLegId(String inboundLegId) {
        this.inboundLegId = inboundLegId;
    }

    public String getOutArrival() {
        return outArrival;
    }

    public void setOutArrival(String outArrival) {
        this.outArrival = outArrival;
    }

    public String getOutDeparture() {
        return outDeparture;
    }

    public void setOutDeparture(String outDeparture) {
        this.outDeparture = outDeparture;
    }

    public Integer getOutStops() {
        return outStops;
    }

    public void setOutStops(Integer outStops) {
        this.outStops = outStops;
    }

    public String getOutboundCarriers() {
        return outboundCarriers;
    }

    public void setOutboundCarriers(String outboundCarriers) {
        this.outboundCarriers = outboundCarriers;
    }

    public String getOutboundCarriersImg() {
        return outboundCarriersImg;
    }

    public void setOutboundCarriersImg(String outboundCarriersImg) {
        this.outboundCarriersImg = outboundCarriersImg;
    }

    public String getOutboundLegId() {
        return outboundLegId;
    }

    public void setOutboundLegId(String outboundLegId) {
        this.outboundLegId = outboundLegId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



}
