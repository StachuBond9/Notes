package pl.stanislaw.domain.Note;

import java.util.Scanner;

public class NoteServiceConsoleGUI {
    public String enterText(){
        System.out.println("Enter text :");
        Scanner text = new Scanner(System.in);
        return text.nextLine();
    }

    public String enterTitle(){
        System.out.println("Enter title");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public String enterId(){
        System.out.println("Enter ID");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
