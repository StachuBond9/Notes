package pl.stanislaw.domain.User;

import java.util.ArrayList;

public interface UserRepository {
    ArrayList<User> users();
    User addUser(User user) ;
    void deleteAll();
}
