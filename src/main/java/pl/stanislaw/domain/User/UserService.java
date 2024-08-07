package pl.stanislaw.domain.User;

import java.util.ArrayList;

public class UserService {

    private final UserRepository userRepository;
    private User activeUser = null;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public int numberOfUsers() {
        return userRepository.users().size();
    }

    public void registration(String name, String login, String password) {
        User user = new User(name, login, password);
        userRepository.addUser(user);

    }

    public boolean login(String login, String password) {

        for (User t : userRepository.users()) {

            if (t.login().equals(login) && t.password().equals(password)) {
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
        return userRepository.users();
    }

    public void logout() {
        activeUser = null;
    }

}
