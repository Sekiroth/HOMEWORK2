package aviasales;

import aviasales.dao.Flight;

public class Test1 {
    public static void main(String[] args) {
        Flight flight = Flight.Builder.create().setFlightId("dfgdgf").setAircraftCode("fg").setFlightMo("fg").build();
        System.out.println(flight.toString());
    }
}
