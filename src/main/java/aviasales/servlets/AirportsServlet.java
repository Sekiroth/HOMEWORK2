package aviasales.servlets;

import aviasales.dao.Airport;
import aviasales.dao.AirportPoolDao;
import aviasales.dao.IAirportDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AirportsServlet", urlPatterns = "/airports")
public class AirportsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IAirportDao airportDao = new AirportPoolDao();
        req.setAttribute("airports", airportDao.getAll());
        req.getRequestDispatcher("/jspAviasales/AirportsDisplay.jsp").forward(req, resp);
    }
}
