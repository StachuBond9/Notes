package pl.stanislaw.domain;

import java.util.ArrayList;

public class UserValidator {
    public  boolean loginCorrect(String login , ArrayList<User> users) {
        int i = 0;
        for (User t : users) {
            if (!t.getLogin().equals(login)) {
                i++;
            }
        }
        return i == users.size() && login.length() >= 5;
    }

    public  boolean passwordCorrect(String password) {
        return password.length() > 5;

    }
}