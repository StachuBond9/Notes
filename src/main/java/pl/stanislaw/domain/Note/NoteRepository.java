package pl.stanislaw.domain.Note;

import java.util.ArrayList;

public interface NoteRepository {
    void addNote(Note note);

    ArrayList<Note> noteList();

    void removeNote(Note note);

    void editText(String replaceText, Note id);
}
