package com.grid.financial;

import com.grid.financial.Factory.ReportFactory;
import com.grid.financial.ReportTemplate.ReportGenerator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private static final String CSV_FILENAME = "taxi-data.csv";

    public static void main(String[] args) throws Exception {
        System.out.println("Financial Report Generation");

        List<Ride> result = new ArrayList<>();

        InputStream inputStream = Client.class.getClassLoader().getResourceAsStream(CSV_FILENAME);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        //Less work to the client
        for (String rawLine; (rawLine = reader.readLine()) != null;) {
            List<String> line = CSVUtils.parseLine(rawLine);
            Ride newRide = RidesParser.parseFromList(line);
            if(newRide != null) {
                result.add(newRide);
            }
        }


//        ReportGenerator report = new PrintedReport(result);
//        report.generateReport();
//        report= new WebReport(result);
//        report.generateReport();
        //Factory method --- The current docTypes allowed are "Printed and "Web" (txt and html extension)
        ReportFactory reportFactory = new ReportFactory();
        ReportGenerator report = reportFactory.createReport("Printed",result);
        ReportGenerator report2 = reportFactory.createReport("Web",result);
        report2.generateReport();
        report.generateReport();

    }
}
