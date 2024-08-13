package pl.stanislaw.domain.User;

import java.util.ArrayList;

public class UserRespiratoryInMemory implements UserRepository {

    ArrayList<User> users = new ArrayList<>();

    @Override
    public ArrayList<User> users() {
        return users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
