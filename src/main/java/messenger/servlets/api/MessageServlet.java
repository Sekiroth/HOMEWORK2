package messenger.servlets.api;


import messenger.dto.Message;
import messenger.dto.User;
import messenger.service.MessageService;
import messenger.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MessageServlet", urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {
    private final MessageService service;

    public MessageServlet() {
        service = MessageService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        User toUser = (User) req.getSession().getAttribute("user");
        for (Message message : service.getMessages(toUser.getLogin())) {
            writer.write("<p>" + message + "</p>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String toUser = req.getParameter("toUser");
        String message = req.getParameter("message");
        User fromUser = (User) req.getSession().getAttribute("user");
        if (UserService.getInstance().isUserExist(fromUser.getLogin(), fromUser.getPassword())) {
            service.send(fromUser.getLogin(), toUser, message);
            resp.sendRedirect(req.getContextPath() + "/answer?answer=success!");
        } else {
            resp.sendRedirect(req.getContextPath() + "/answer?answer=something went wrong");
        }
    }
}
