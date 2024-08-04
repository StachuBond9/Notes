package pl.stanislaw.domain;

import java.util.ArrayList;

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


    public String login(String login) {
        int indeks = 0;
        for (User t : users) {
            if (t.getLogin().equals(login)) {
                return Integer.toString(indeks);
            }
            indeks++;
        }
        return null;
    }

    public boolean loginPassword(int indeks, String password){
            if (users.get(indeks).getPassword().equals(password)) {
                activeUser = users.get(indeks);
                return true;
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
