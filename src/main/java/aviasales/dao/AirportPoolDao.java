package aviasales.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirportPoolDao implements IAirportDao{

    private static final AirportPoolDao instance = new AirportPoolDao();

    public AirportPoolDao() {
    }

    @Override
    public List<Airport> getAll() {
        List<Airport> airports = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT airport_code, airport_name, city, coordinates, timezone\n" +
                     "\tFROM bookings.airports\n" +
                     "\tLIMIT 100;")) {
            while(resultSet.next()) {
                airports.add(map(resultSet));
            }
            return airports;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Airport get(String code) {
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT airport_code, airport_name, city, coordinates, timezone\n" +
                     "\tFROM bookings.airports\n" +
                     "WHERE airport_code = '" + code + "';")) {
            while(resultSet.next()) {
                return map(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Airport map(ResultSet resultSet) throws SQLException {
        return new Airport(resultSet.getString("airport_code"),
                resultSet.getString("airport_name"),
                resultSet.getString("city"),
                resultSet.getString("coordinates"),
                resultSet.getString("timezone"));
    }

    @Override
    public void close() throws Exception {
        ConnectionFactory.close();
    }

    public static AirportPoolDao getInstance() {
        return instance;
    }
}
