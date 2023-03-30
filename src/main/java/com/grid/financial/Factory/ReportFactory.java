package com.grid.financial.Factory;

import com.grid.financial.ReportTemplate.PrintedReport;
import com.grid.financial.ReportTemplate.ReportGenerator;
import com.grid.financial.ReportTemplate.WebReport;
import com.grid.financial.Ride;

import java.util.List;

public class ReportFactory {
    public ReportGenerator createReport(String docType, List<Ride> rides){
        if (docType ==  null || docType.isEmpty())return null;
        else if (docType.equalsIgnoreCase("Printed"))return new PrintedReport(rides);
        else if (docType.equalsIgnoreCase("Web"))return new WebReport(rides);
        return null;
        }
    }

