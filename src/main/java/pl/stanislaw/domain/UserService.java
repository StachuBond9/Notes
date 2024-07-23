package pl.stanislaw.domain;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {

    private User activeUser = null;
    private final ArrayList<User> users = new ArrayList<>();

    public void registration() {
        User user = new User();
        System.out.println("Set name : ");
        Scanner name = new Scanner(System.in);
        user.setName(name.next());

        System.out.println("Set login");
        Scanner login = new Scanner(System.in);
        user.setLogin(login.next());

        System.out.println("Set password");
        Scanner password = new Scanner(System.in);
        user.setPassword(password.next());

        users.add(user);

    }

    public void login() {
        System.out.println("Enter login : ");
        Scanner loginSc = new Scanner(System.in);
        String login = loginSc.next();
        boolean loginExist = false;
        int userNumber = 0;
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                loginExist = true;
                break;
            }
            userNumber++;
        }
        if (!loginExist) {
            System.out.println("Login doesn't exist");
            login();
        }
        System.out.println("Enter password : ");
        Scanner passwordSc = new Scanner(System.in);
        String password = passwordSc.next();
        if (password.equals(users.get(userNumber).getPassword())) {
            System.out.println(users.get(userNumber).getName() + " logged correctly");
        }

        activeUser = users.get(userNumber);
    }

    public User loggedUser() {
        return activeUser;
    }

    public ArrayList<User> registeredUsers() {
        return users;
    }

    public void logout(){
        activeUser = null;
    }

}
