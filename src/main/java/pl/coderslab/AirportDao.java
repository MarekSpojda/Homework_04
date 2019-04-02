package pl.coderslab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AirportDao {
    public List<Airport> getList() {
        List<Airport> listOfAirports = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/marek/Pulpit/java_gits/Homework_04/src/main/airports.txt"));
            String field;
            while ((field = bufferedReader.readLine()) != null) {
                String[] fieldTab = field.split(";");
                Airport airport = new Airport(fieldTab[0], fieldTab[1], fieldTab[2]);
                listOfAirports.add(airport);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listOfAirports;
    }
}
