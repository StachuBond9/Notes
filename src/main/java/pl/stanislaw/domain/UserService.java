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

    public void login(String login, String password) {
        int indeks = 0;

        for (int i = 10; i > 0; i--) {


            boolean isLoginFound = false;
            indeks = 0;
            for (User t : users) {

                if (t.getLogin().equals(login)) {
                    isLoginFound = true;
                }
            }
            if (isLoginFound) {
                break;
            }
            System.out.println("Login not found\nYou have " + (i - 1) + " trials avaiable");
            if (i - 1 == 0) {
                return;
            }
            indeks++;
        }

        for (int i = 3; i > 0; i--) {

            if (users.get(indeks).getPassword().equals(password)) {
                activeUser = users.get(indeks);
                System.out.println("Login corectly");
                break;
            }
            System.out.println("Wrong password");
            System.out.println("You have only " + i + " trials avaiable");
            if (i - 1 == 0) {
                return;
            }
        }
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
