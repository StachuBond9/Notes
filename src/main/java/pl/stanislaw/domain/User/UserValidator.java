package pl.stanislaw.domain.User;

import java.util.ArrayList;

public class UserValidator {
    public  boolean loginCorrect(String login , ArrayList<User> users) {
        int i = 0;
        for (User t : users) {
            if (!t.login().equals(login)) {
                i++;
            }
        }
        return i == users.size() && login.length() >= 5;
    }

    public  boolean passwordCorrect(String password) {
        return password.length() > 5;

    }

}