package pl.stanislaw.domain.Note;

import pl.stanislaw.domain.User.User;


public record Note(String title, String text, String id , User user ) {

    @Override
    public String toString() {
        return  "\t\t\t" + title + '\'' +
                "\n" + text + '\'' +
                "\n";
    }
}
