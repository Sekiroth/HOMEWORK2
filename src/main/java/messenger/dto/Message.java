package messenger.dto;

import java.time.LocalDateTime;

public class Message {
    private User from, to;
    private LocalDateTime sendTime;
    private String message;

    public Message(User from, User to, String message) {
        this.from = from;
        this.to = to;
        this.message = message;
        this.sendTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Message " +
                "from " + from +
                ", to " + to +
                ", when " + sendTime +
                ", message '" + message + '\'';
    }
}
