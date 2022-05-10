package aviasales;

import aviasales.dao.Airport;
import aviasales.dao.AirportPoolDao;
import aviasales.dao.IAirportDao;

public class Test2 {
    public static void main(String[] args) {
        IAirportDao airportDao = new AirportPoolDao();
        for (Airport airport : airportDao.getAll()) {
            System.out.println(airport.toString());
        }
    }
}
