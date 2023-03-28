package com.grid.financial.RideBuilder;

import java.util.Date;

public interface Builder {
    RideBuilder setTaxiId(long taxiId);
    RideBuilder setPickUpTime(Date pickUpTime);
    RideBuilder setDropOffTime(Date dropOffTime);
    RideBuilder setPassengerCount(int passengerCount);
    RideBuilder setTripDistance(double tripDistance);
    RideBuilder setTollsAmount(double tollsAmount);
}
//    long taxiId,
//    Date pickUpTime,
//    Date dropOffTime,
//    int passengerCount,
//    double tripDistance,
//    double tollsAmount