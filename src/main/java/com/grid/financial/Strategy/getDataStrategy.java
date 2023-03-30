package com.grid.financial.Strategy;

import com.grid.financial.Ride;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface getFileDataStrategy {

    <T extends String /*Can add another kind of object from a class o subclass*/> void generateData(T dataSource , List<Ride> result) throws IOException;
}
