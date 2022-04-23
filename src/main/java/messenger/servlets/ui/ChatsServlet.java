package messenger.servlets.ui;


import messenger.dto.Message;
import messenger.dto.User;
import messenger.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChatsServlet", urlPatterns = "/ui/user/chats")
public class ChatsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User toUser = (User) req.getSession().getAttribute("user");
        List<Message> messageList = MessageService.getInstance().getMessages(toUser.getLogin());
        req.setAttribute("message", messageList);

        req.getRequestDispatcher("/jsp/Chats.jsp").forward(req, resp);
    }
}
