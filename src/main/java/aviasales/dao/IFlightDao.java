package aviasales.dao;

import java.util.List;

public interface IFlightDao extends AutoCloseable {

    List<Flight> getAll();

    List<Flight> list(FlightFilter filter);

    Flight get(String id);
}

