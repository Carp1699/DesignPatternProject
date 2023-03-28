package com.grid.financial;

import com.grid.financial.ReportTemplate.PrintedReport;
import com.grid.financial.ReportTemplate.ReportGenerator;
import com.grid.financial.ReportTemplate.WebReport;

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

//        WebReport webReport = new WebReport();
        ReportGenerator report = new PrintedReport(result);
        report.generateReport();
        report= new WebReport(result);
        report.generateReport(); //Factory method
        StringBuilder uwu = new StringBuilder();
    }
}
