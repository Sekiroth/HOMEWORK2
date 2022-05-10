package aviasales.dao;

import java.util.List;

public interface IAirportDao extends AutoCloseable{
    List<Airport> getAll();
    Airport get(String code);
}
