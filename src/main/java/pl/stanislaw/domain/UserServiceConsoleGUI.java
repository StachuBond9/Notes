package pl.stanislaw.domain;

import java.util.ArrayList;
import java.util.Scanner;

public class UserServiceConsoleGUI {

    UserValidator userValidator = new UserValidator();
    // Registration
    public String nameReg() {
        System.out.println("Set name : ");
        Scanner name = new Scanner(System.in);
        return name.next();
    }

    public String loginReg(ArrayList<User> users) {
        while (true) {
            String login = enterLogin();

            if (userValidator.loginCorrect(login , users)) {
                return login;
            }
            System.out.println("Login is taken or too short");
        }
    }

    public String passwordReg() {
        while (true) {
            String password = enterPassword();

            if (userValidator.passwordCorrect(password)) {
                return password;
            }
            System.out.println("Password is to short");
        }
    }

    //login
    public String enterLogin(){
        System.out.println("Enter login");
        Scanner loginSc = new Scanner(System.in);
         return loginSc.next();
    }
    public String enterPassword(){
        System.out.println("Enter password");
        Scanner passwordSc = new Scanner(System.in);
        return passwordSc.next();
    }

    public int menuChose() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }





}
