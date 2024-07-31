package pl.stanislaw;

import pl.stanislaw.domain.NoteService;
import pl.stanislaw.domain.User;
import pl.stanislaw.domain.UserService;
import pl.stanislaw.domain.UserServiceConsoleGUI;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static UserService userService = new UserService();
    static UserServiceConsoleGUI service = new UserServiceConsoleGUI();
    static NoteService noteService = new NoteService();

    static void menuWhenNotLoggedIn() {
        System.out.println("1.Exit");
        System.out.println("2.Add user");
        System.out.println("3.Login");
        System.out.println("4.Registered users");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                return;
            case 2:

                userService.registration(service.nameReg(), service.loginReg(userService.registeredUsers()), service.passwordReg());
                break;
            case 3:
                if (userService.numberOfUsers() <= 0) {
                    System.out.println("No registered users");
                    userService.registration(service.nameReg(), service.loginReg(userService.registeredUsers()), service.passwordReg());
                }
                userService.login(service.login(), service.password());
                break;
            case 4:
                System.out.println(userService.registeredUsers());
                break;

            default:
                System.out.println("Wrong option");
                break;

        }
    }

    static void menuWhenLoggedIn() {
        System.out.println("1. Exit");
        System.out.println("2. Logged user");
        System.out.println("3. Create note ");
        System.out.println("4. Edit note");
        System.out.println("5. Saved notes");
        System.out.println("6. Delete note");



    }

    public static void main(String[] args) {


        do {
            if (userService.loggedUser() == null) {
                menuWhenNotLoggedIn();
            } else {
                menuWhenLoggedIn();
            }

        } while (true);


    }
}