package pl.stanislaw.domain.User;

import java.io.IOException;
import java.util.ArrayList;

public interface UserRepository {
    ArrayList<User> users();
    void addUser(User user) ;
}
