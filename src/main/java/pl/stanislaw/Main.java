package pl.stanislaw;

import pl.stanislaw.domain.User;
import pl.stanislaw.domain.UserService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        do {
            System.out.println("1.Add user");
            System.out.println("2.Login");
            System.out.println("3.Logged user");
            System.out.println("4.Registered users");
            System.out.println("5.Logout");
            System.out.println("6.Exit");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()){
                case 1:
                    userService.registration();
                    break;
                case 2:
                    userService.login();
                    break;
                case 3:
                    System.out.println(userService.loggedUser());
                    break;
                case 4:
                    System.out.println(userService.registeredUsers());
                    break;
                case 5:
                    userService.logout();
                    System.out.println("User logout");
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Wrong option");
                    break;

            }
        }while (true);


    }
}