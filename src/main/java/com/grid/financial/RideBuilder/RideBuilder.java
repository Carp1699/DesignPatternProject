package com.grid.financial.RideBuilder;

import com.grid.financial.Ride;

import java.util.Date;

public class RideBuilder implements Builder {

    private long taxiId;
    private Date pickUpTime;
    private Date dropOffTime;
    private int passengerCount;
    private double tripDistance;
    private double tollsAmount;
    @Override
    public RideBuilder setTaxiId(long taxiId) {
        this.taxiId = taxiId;
        return this;
    }
    @Override
    public RideBuilder setPickUpTime(Date pickUpTime) {
        this.pickUpTime = pickUpTime;
        return this;
    }

    @Override
    public RideBuilder setDropOffTime(Date dropOffTime) {
        this.dropOffTime = dropOffTime;
        return this;
    }
    @Override
    public RideBuilder setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
        return this;
    }
    @Override
    public RideBuilder setTripDistance(double tripDistance) {
        this.tripDistance = tripDistance;
        return this;
    }
    @Override
    public RideBuilder setTollsAmount(double tollsAmount) {
        this.tollsAmount = tollsAmount;
        return this;
    }
    public Ride build(){
        return new Ride(taxiId,pickUpTime,dropOffTime,passengerCount,tripDistance,tollsAmount);
    }
}
