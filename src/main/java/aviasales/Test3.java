package aviasales;

import aviasales.dao.Flight;
import aviasales.dao.FlightDao;
import aviasales.dao.FlightFilter;
import aviasales.dao.IFlightDao;

import java.util.List;

public class
Test3 {
    public static void main(String[] args) {
        FlightFilter filter = FlightFilter.Builder.create()
                .setArrivalAirport("YKS")
                .setDepartureAirport("LED")
                .build();
        IFlightDao flightDao = new FlightDao();
        List<Flight> list = flightDao.list(filter);
        for (Flight flight : list) {
            System.out.println(flight.toString());
        }
    }
}
