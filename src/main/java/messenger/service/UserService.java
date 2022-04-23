package messenger.service;

import messenger.dto.Role;
import messenger.dto.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserService {
    private static final UserService instance = new UserService();
    private final List<User> users;

    public static UserService getInstance() {
        return instance;
    }

    private UserService() {
        this.users = new CopyOnWriteArrayList<>();
        User admin = new User("admin", "admin", "admin", "admin", LocalDate.MIN);
        admin.setRole(Role.ADMIN);
        users.add(admin);
    }

    public List<User> getUsers() {
        return users;
    }

    public User create(String login, String password, String firstName, String lastName, LocalDate birthday) {
        User user = new User(login, password, firstName, lastName, birthday);
        user.setRole(Role.USER);
        return user;
    }

    public void register(String login, String password, String firstName, String lastName, LocalDate birthday) {
        User user = create(login, password, firstName, lastName, birthday);

        for (User userDto : users) {
            if (Objects.equals(userDto.getLogin(), user.getLogin())) {
                throw new IllegalArgumentException("The user already exists");
            }
        }
        StatisticService.getInstance().incAllUsers();
        users.add(user);
    }

    public boolean isUserExist(String login, String password) {
        boolean result = false;

        for (User user : users) {
            if (Objects.equals(user.getLogin(), login) && Objects.equals(user.getPassword(), password)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public User getUser(String login) {
        User find = null;

        for (User user : users) {
            if (Objects.equals(user.getLogin(), login)) {
                find = user;
                break;
            }
        }
        return find;
    }
}

