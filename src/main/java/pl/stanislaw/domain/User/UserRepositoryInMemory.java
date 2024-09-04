package pl.stanislaw.domain.User;

import java.util.ArrayList;

public class UserRepositoryInMemory implements UserRepository {

    private final ArrayList<User> users = new ArrayList<>();

    @Override
    public ArrayList<User> users() {
        return users;
    }

    @Override
    public User addUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public void deleteAll() {
        users.clear();
    }
}
