package messenger.servlets.api;


import messenger.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;


@WebServlet(name = "UserServlet", urlPatterns = "/api/user")
public class UserServlet extends HttpServlet {
    private final UserService service;

    public UserServlet() {
        this.service = UserService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String birthday = req.getParameter("birthday");

        boolean flag=service.isUserExist(login,password);

        if(!flag){
            service.register(login, password, firstName, lastName, LocalDate.parse(birthday));
            resp.sendRedirect(req.getContextPath() + "/answer?answer=success!");
        }else{
            resp.sendRedirect(req.getContextPath()+"/answer?answer=already exists");
        }
    }
}
