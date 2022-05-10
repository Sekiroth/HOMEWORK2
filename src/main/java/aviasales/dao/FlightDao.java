package aviasales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightDao implements IFlightDao{
    private final static String SELECT_SQL = "SELECT flight_id, flight_no, scheduled_departure, " +
            "scheduled_arrival, departure_airport, arrival_airport, " +
            "status, aircraft_code, actual_departure, actual_arrival FROM bookings.flights";

    @Override
    public List<Flight> getAll() {
        return null;
    }

    @Override
    public List<Flight> list(FlightFilter filter) {
        if(filter == null){
            filter = FlightFilter.Builder.create().build();
        }

        List<Flight> flights = new ArrayList<>();

        List<Object> params = new ArrayList<>();

        String where = "";

        if(filter.getArrivalAirport() != null){
            where += " arrival_airport = ?";
            params.add(filter.getArrivalAirport());
        }

        if(filter.getDepartureAirport() != null){
            if(where.length() > 0){
                where += " AND ";
            }
            where += " departure_airport = ?";
            params.add(filter.getDepartureAirport());
        }

//        if(filter.getScheduledArrival() != null){
//            if(where.length() > 0){
//                where += " AND ";
//            }
//            where += " scheduled_arrival = ?";
//            params.add(filter.getScheduledArrival());
//        }
//
//        if(filter.getScheduledDeparture() != null){
//            if(where.length() > 0){
//                where += " AND ";
//            }
//            where += " scheduled_departure = ?";
//            params.add(filter.getScheduledDeparture());
//        }

        if(where.length() > 0){
            where = " WHERE " + where;
        }

//        String page = "";
//
//        if(pageable.getSize() > 0){
//            page += " LIMIT " + pageable.getSize();
//        }
//        if (pageable.getPage() > 0){
//            int offset = pageable.getSize() * (pageable.getPage() - 1);
//
//            page += " OFFSET " + offset;
//        }

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SQL + where + ";");
        ) {
            int index = 0;
            for (Object param : params) {
                statement.setObject(++index, param);
            }

            try(ResultSet resultSet = statement.executeQuery();){
                while (resultSet.next()){
                    flights.add(map(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return flights;
    }

    private Flight map(ResultSet rs) throws SQLException {
        return Flight.Builder.create()
                .setFlightId(rs.getString("flight_id"))
                .setFlightMo(rs.getString("flight_no"))
                .setScheduledDeparture(LocalDate.parse(rs.getString("scheduled_departure")))
                .setScheduledArrival(LocalDate.parse(rs.getString("scheduled_arrival")))
                .setDepartureAirport(rs.getString("departure_airport"))
                .setArrivalAirport(rs.getString("arrival_airport"))
                .setStatus(rs.getString("status"))
                .setAircraftCode(rs.getString("aircraft_code"))
//                .setActualDeparture(rs.getString("actual_departure"))
//                .setActualArrival(rs.getString("actual_arrival"))
                .build();
    }

    @Override
    public Flight get(String id) {
        return null;
    }

    @Override
    public void close() throws Exception {
        ConnectionFactory.close();
    }
}
