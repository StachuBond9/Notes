package pl.stanislaw.domain.Note;

import pl.stanislaw.domain.User.User;

import java.util.ArrayList;

public class NoteRepositoryInMemory implements NoteRepository {
    private ArrayList<Note> notes = new ArrayList<>();

    @Override
    public void addNote(Note note) {
        notes.add(note);
    }

    @Override
    public void removeNote(Note note) {
        notes.remove(note);
    }

    @Override
    public void editText(String replaceText, Note id) {
        Note newNote = new Note(id.title(), replaceText, id.id(), id.user());
        notes.remove(id);
        notes.add(newNote);
    }

    @Override
    public ArrayList<Note> noteList() {
        return notes;
    }


}
