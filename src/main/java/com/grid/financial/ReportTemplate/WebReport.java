package com.grid.financial.ReportTemplate;

import com.grid.financial.ReportTemplate.ReportGenerator;
import com.grid.financial.Ride;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WebReport extends ReportGenerator {
    public WebReport(List<Ride> rides)  {
        this.rides = rides;
    }

    @Override
    public String createHeader(String title) {
        return "<h1>" + title + "</h1>";
    }

    @Override
    public FileWriter createFile() throws IOException {
        FileWriter fileWriter = new FileWriter("financial-report.html");
        this.fileWriter = fileWriter;
        return fileWriter;
    }

    @Override
    public String createContent(List<Ride> rides) {
        StringBuilder builder = new StringBuilder();
        builder.append(createHeader("Taxi Report"));
        builder.append(createTableHeaders());
        rides.forEach( ride -> {
            builder.append(addRide(ride));

        });
        builder.append("<br>");
        builder.append(closeTableHeaders());
        this.content = builder.toString();
        return builder.toString();
    }


    public String createTableHeaders() {
        return "<table>" +
                "<tr>" +
                "<th> TaxiID </th>" +
                "<th> Pickup time </th>" +
                "<th> Dropoff time </th>" +
                "<th> Passenger count </th>" +
                "<th> Trip Distance </th>" +
                "<th> Total amount </th>" +
                "</tr> <br>";
    }

    private String closeTableHeaders() {
        return "</table>";
    }

    public String addRide(Ride ride) {
        return  "<tr style=\"height:30px\">" +
                "<td>" + ride.getTaxiId() + "</td>" +
                "<td>" + ride.getPickUpTime() + "</td>" +
                "<td>" + ride.getDropOffTime() + "</td>" +
                "<td>" + ride.getPassengerCount() + "</td>" +
                "<td>" + ride.getTripDistance() + "</td>" +
                "<td>" + formatAmount(ride.getTollsAmount()) + "</td>" +
                "</tr> " ;
    }

    private String formatAmount(double amount) {
        if(amount < 0) {
            return "<span style='color:red'>" + amount + "</span>";
        }
        return Double.toString(amount);
    }
}
