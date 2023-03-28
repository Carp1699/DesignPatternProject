package com.grid.financial.ReportTemplate;

import com.grid.financial.Ride;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PrintedReport extends ReportGenerator {
    public PrintedReport (List<Ride> rides)  {
        this.rides = rides;
    }

    @Override
    public String createHeader(String title) {
        return "Taxi Report \n";
    }

    @Override
    public String createTableHeaders() {
        return "\n TaxiID                    PickUp Time                 DropOff Time  \t       Passenger Count   \t   Trip Distance     Total Amount\n";
    }


    @Override
    public FileWriter createFile() throws IOException {
        FileWriter fileWriter = new FileWriter("financial-report.txt");
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
        this.content = builder.toString();
        return builder.toString();
    }
    @Override
    public String addRide(Ride ride) {
        return
                  ride.getTaxiId() + " " +
                "\t \t " + ride.getPickUpTime() + "\t \t" +
                " " + ride.getDropOffTime() + " " +
                " \t\t" + ride.getPassengerCount() + " \t\t" +
                "\t\t\t " + ride.getTripDistance() + " " +
                " \t\t\t\t\t" + formatAmount(ride.getTollsAmount()) + " " +
                "\n " ;
    }
    private String formatAmount(double amount) {
        if(amount < 0) {
            return "   " + amount + "  ";
        }
        return Double.toString(amount);
    }
}
