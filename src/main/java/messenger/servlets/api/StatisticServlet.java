package messenger.servlets.api;

import messenger.service.StatisticService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StatisticServlet", urlPatterns = "/api/admin/statistics")
public class StatisticServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.write("<p>" + StatisticService.getInstance().getSentMessages() + "<p>");
        writer.write("<p>" + StatisticService.getInstance().getLoggedUsers() + "<p>");
        writer.write("<p>" + StatisticService.getInstance().getAllUsers() + "<p>");
    }

}
