package pl.stanislaw.domain.Note;

import pl.stanislaw.domain.User.User;

import java.util.ArrayList;

public class NoteRepositoryInMemory implements NoteRepository {
    private final ArrayList<Note> notes = new ArrayList<>();

    @Override
    public void addNote(Note note) {
        notes.add(note);
    }

    @Override
    public void removeNote(Note note) {
        notes.remove(note);
    }

    @Override
    public void editText(String replaceText, Note note) {
        Note newNote = new Note(note.title(), replaceText, note.id(), note.user());
        notes.remove(note);
        notes.add(newNote);
    }

    @Override
    public void deleteAll() {
        notes.clear();
    }

    @Override
    public ArrayList<Note> noteList() {
        return notes;
    }


}
