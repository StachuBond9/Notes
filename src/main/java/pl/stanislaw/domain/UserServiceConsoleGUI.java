package pl.stanislaw.domain;

import java.util.ArrayList;
import java.util.Scanner;

public class UserServiceConsoleGUI {

    // Registration
    public String nameReg() {
        System.out.println("Set name : ");
        Scanner name = new Scanner(System.in);
        return name.next();
    }

    public String loginReg(ArrayList<User> users) {
        while (true) {
            System.out.println("Set login");
            Scanner loginSc = new Scanner(System.in);
            String login = loginSc.next();
            int i = 0;
            for (User t :  users) {
                if (!t.getLogin().equals(login)) {
                    i++;
                }
            }
            if (i == users.size() && login.length() >= 5) {
                return login;
            }
            System.out.println("Login is taken or too short");
        }
    }

    public String passwordReg() {
        while (true) {
            System.out.println("Set password");
            Scanner passwordSc = new Scanner(System.in);
            String password = passwordSc.next();

            if (password.length() > 5) {
                return password;
            }
            System.out.println("Password is to short");
        }
    }

    //login
    public String login(){
        System.out.println("Enter login");
        Scanner loginSc = new Scanner(System.in);
         return loginSc.next();
    }
    public String password(){
        System.out.println("Enter password");
        Scanner passwordSc = new Scanner(System.in);
        return passwordSc.next();
    }


}
