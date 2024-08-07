package pl.stanislaw.domain;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {

    private User activeUser = null;
    private final ArrayList<User> users = new ArrayList<>();

    public int numberOfUsers() {
        return users.size();
    }

    public void registration(String name, String login, String password) {
        User user = new User(name, login, password);
        users.add(user);

    }

    public boolean login(String login, String password) {

        for (User t : users) {

            if (t.getLogin().equals(login) && t.getPassword().equals(password)) {
                activeUser = t;
                return true;
            }
        }
        return false;
    }


    public User loggedUser() {
        return activeUser;
    }

    public ArrayList<User> registeredUsers() {
        return users;
    }

    public void logout() {
        activeUser = null;
    }

}
