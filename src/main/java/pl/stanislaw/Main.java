package pl.stanislaw;

import pl.stanislaw.domain.*;

import java.util.Scanner;

public class Main {

    static UserService userService = new UserService();
    static UserServiceConsoleGUI userGUI = new UserServiceConsoleGUI();
    static NoteService noteService = new NoteService();
    static NoteServiceConsoleGUI noteGUI = new NoteServiceConsoleGUI();
    static boolean exit = false;

    static void menuWhenNotLoggedIn() {
        System.out.println("1.Exit");
        System.out.println("2.Add user");
        System.out.println("3.Login");
        System.out.println("4.Registered users");

        switch (userGUI.menuChose()) {
            case 1:
                exit = true;
                return;
            case 2:
                userService.registration(userGUI.name(), userGUI.loginRe(userService.registeredUsers()), userGUI.passwordRe());
                break;
            case 3:
                if (userService.numberOfUsers() <= 0) {
                    System.out.println("No registered users");
                    userService.registration(userGUI.name(), userGUI.loginRe(userService.registeredUsers()), userGUI.passwordRe());
                }
                for (int i = 0; i < 5; i++) {
                    String indeksS = userService.login(userGUI.login());
                    if (indeksS != null) {
                        int indeks = Integer.parseInt(indeksS);

                        for (int j = 0; j < 3; j++) {
                            if (userService.loginPassword(indeks, userGUI.password())) {
                                return;
                            }
                        }
                        return;
                    }
                }

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
        System.out.println("3. Logout");
        System.out.println("4. Create note ");
        System.out.println("5. Edit note");
        System.out.println("6. Saved notes");
        System.out.println("7. Delete note");



        switch (userGUI.menuChose()) {
            case 1:
                exit = true;
                return;
            case 2:
                System.out.println(userService.loggedUser());
                break;
            case 3:
                System.out.println("Log outing");
                userService.logout();
                break;
            case 4:
                noteService.createNote(noteGUI.enterTitle(), userService.loggedUser());
                break;
            case 5:
                noteService.editText(noteGUI.enterId(), noteGUI.enterText());
                break;
            case 6:
                System.out.println(noteService.savedNote(userService.loggedUser()));
                break;
            case 7:
                noteService.delete(noteGUI.enterId());
                break;
            default:
                System.out.println("Wrong options");
                break;

        }


    }

    public static void main(String[] args) {

        do {
            if (userService.loggedUser() == null) {
                menuWhenNotLoggedIn();
            } else {
                menuWhenLoggedIn();
            }
        } while (!exit);

    }
}