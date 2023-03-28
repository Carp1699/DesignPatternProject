package com.grid.financial.ReportTemplate;

import com.grid.financial.Ride;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public abstract class ReportGenerator {
    String content;
    List<Ride> rides;

    FileWriter fileWriter;
    //Template method, final so subclasses cant override
    public final void generateReport() throws IOException {
        createContent( this.rides);
        createFile();
        printInFile(this.content,this.fileWriter);
    }
    //default implementation
    private void printInFile(String content,FileWriter fileWriter){
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(content);
        printWriter.close();
    }

    //methods to be implemented by subclasses
    public abstract String createHeader(String title);
    public abstract String createTableHeaders();
    public abstract String addRide(Ride ride);
    public abstract FileWriter createFile() throws IOException;
    public abstract String createContent (List<Ride> rides);

}
