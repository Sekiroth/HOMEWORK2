package aviasales.servlets;

import aviasales.dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FindFlightServlet", urlPatterns = "/flights")
public class FindFlightServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IAirportDao airportDao = new AirportPoolDao();
        List<Airport> airports = airportDao.getAll();
        req.setAttribute("airports", airports);
        if(req.getParameter("departureAirport") != null) {
            FlightFilter filter = FlightFilter.Builder.create()
                    .setArrivalAirport(req.getParameter("arrivalAirport"))
                    .setDepartureAirport(req.getParameter("departureAirport"))
                    .build();
            IFlightDao flightDao = new FlightDao();
            List<Flight> list = flightDao.list(filter);
            req.setAttribute("flights", list);
        }

        req.getRequestDispatcher("/jspAviasales/Searching.jsp").forward(req, resp);
    }
}
