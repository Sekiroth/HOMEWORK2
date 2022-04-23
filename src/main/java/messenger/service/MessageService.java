package messenger.service;


import messenger.dto.Message;
import messenger.dto.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageService {
    private static final MessageService instance = new MessageService();
    private final Map<User, List<Message>> messages;

    UserService service = UserService.getInstance();

    public static MessageService getInstance() {
        return instance;
    }

    private MessageService() {
        this.messages = new ConcurrentHashMap<>();
    }

    public Message create(User fromWho, User toWho, String message) {
        return new Message(fromWho, toWho, message);
    }

    public void send(String fromTo, String toWho, String text) {
        User toUser = service.getUser(toWho);
        User fromUser = service.getUser(fromTo);
        if (service.getUsers().contains(fromUser)) {
            Message message = create(fromUser, toUser, text);
            List<Message> messageList;

            if (messages.containsKey(toUser)) {
                messageList = messages.get(toUser);
            } else {
                messageList = new ArrayList<>();
            }

            messageList.add(message);
            StatisticService.getInstance().incSentMessages();
            messages.put(toUser, messageList);
        }
    }

    public List<Message> getMessages(String toWho) {
        User toUser = service.getUser(toWho);
        return messages.get(toUser);
    }
}
