package pl.stanislaw;

import pl.stanislaw.domain.Note.*;
import pl.stanislaw.domain.User.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    static UserService userService = new UserService(new UserRepositorySQL());
    static UserServiceConsoleGUI userGUI = new UserServiceConsoleGUI();
    static NoteService noteService = new NoteService(new NoteRepositorySQL());
    static NoteServiceConsoleGUI noteGUI = new NoteServiceConsoleGUI();
    static boolean exit = false;

    static public Note getNote() {
        System.out.println("How do you want to find note ?");
        System.out.println("1. By text");
        System.out.println("2. By title");
        int type;
        List<Note> sameNameNote;
        try {
            Scanner scanner = new Scanner(System.in);
            type = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Option no avaiable");
            return null;
        }
        switch (type) {
            case 1:
                sameNameNote = noteService.getNotesByContainedText(noteGUI.enterText(), userService.loggedUser());
                break;
            case 2:
                sameNameNote = noteService.getNotesByTitle(noteGUI.enterTitle(), userService.loggedUser());
                break;
            default:
                System.out.println("Wrong option");
                return null;
        }
        int i = 1;
        if (sameNameNote.size() > 0) {
            for (Note note : sameNameNote) {
                System.out.println(i + note.toString());
                i++;
            }
            System.out.println("Which note do you want chose ? ");
            Scanner note = new Scanner(System.in);
            return sameNameNote.get(note.nextInt() - 1);
        }
        return null;
    }

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
                do {
                    loggedCorectly = userService.login(userGUI.enterLogin(), userGUI.enterPassword());
                    i++;

                } while (!loggedCorectly || i == 5);

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
        System.out.println("7. Sort note by tittle");
        System.out.println("8. Map note to text");
        System.out.println("9. Delete note");


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
                noteService.editText(getNote(), noteGUI.enterText());
                break;
            case 6:
                System.out.println(noteService.savedNote(userService.loggedUser()));
                break;
            case 7:
                System.out.println(noteService.sortNotesByTitle(userService.loggedUser()));
                break;
            case 8:
                System.out.println(noteService.mapNotesToText(userService.loggedUser()));
                break;

            case 9:
                noteService.delete(getNote());
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