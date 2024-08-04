package pl.stanislaw.domain;

import java.util.ArrayList;
import java.util.Scanner;

public class UserServiceConsoleGUI {
    UserValidator validator = new UserValidator();

    public int menuChose(){
        try{
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        }
        catch (Exception e){
            System.out.println("Wrong data, try again");
            return 0;
        }
    }

    // Registration
    public String name() {
        System.out.println("Set name : ");
        Scanner name = new Scanner(System.in);
        return name.next();
    }


    //login
    public String loginRe(ArrayList<User> users) {
        while (true) {
            String login = login();
            if (validator.loginCorrect(login, users)) {
                return login;
            }
            System.out.println("Login error");
        }


    }

    // password
    public String passwordRe() {
        while (true) {

            String password = password();
            if (validator.passwordCorrect(password)) {
                return password;
            }
            System.out.println("Password too short");
        }

    }


    public String login(){
        System.out.println("Enter login : ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public String password(){
        System.out.println("Enter password : ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }




}
