package aviasales.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirportDao implements IAirportDao{
    public List<Airport> getAll() {
        List<Airport> airports = new ArrayList<>();
        try (Connection connection = getConnection();
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

    public Airport get(String code) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT airport_code, airport_name, city, coordinates, timezone\n" +
                     "\tFROM bookings.airports\n" +
                     "WHERE airport_code = '" + code + "';");){

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

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/demo" ,
                "postgres" ,
                "postgres");
        return connection;
    }

    @Override
    public void close() throws Exception {

    }
}
