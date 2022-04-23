package messenger.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private String login, password, firstName, lastName;
    private LocalDate birthday;
    private LocalDateTime time;
    private Role role;

    public User(String login, String password, String firstName, String lastName, LocalDate birthday) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.role = Role.USER;
        this.time = LocalDateTime.now();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", time=" + time +
                ", role=" + role +
                '}';
    }
}
