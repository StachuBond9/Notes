package pl.stanislaw;

import pl.stanislaw.domain.Note.NoteRepositoryInFile;
import pl.stanislaw.domain.Note.NoteService;
import pl.stanislaw.domain.Note.NoteServiceConsoleGUI;
import pl.stanislaw.domain.User.UserRepositoryInFile;
import pl.stanislaw.domain.User.UserService;
import pl.stanislaw.domain.User.UserServiceConsoleGUI;

public class Main {

    static UserService userService = new UserService(new UserRepositoryInFile());
    static UserServiceConsoleGUI userGUI = new UserServiceConsoleGUI();
    static NoteService noteService = new NoteService(new NoteRepositoryInFile());
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
                userService.registration(userGUI.nameReg(), userGUI.loginReg(userService.registeredUsers()), userGUI.passwordReg());
                break;
            case 3:
                if (userService.numberOfUsers() <= 0) {
                    System.out.println("No registered users");
                    userService.registration(userGUI.nameReg(), userGUI.loginReg(userService.registeredUsers()), userGUI.passwordReg());
                }
                boolean loggedCorectly = false;
                int i = 0;
                do{
                    loggedCorectly = userService.login(userGUI.enterLogin(), userGUI.enterPassword());
                    i++;

                }while(!loggedCorectly || i ==5);

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