package pl.stanislaw.domain;

import java.util.ArrayList;
import java.util.UUID;

public class NoteService {
    private final ArrayList<Note> notes = new ArrayList<>();

    public void createNote(String title, User user) {
        Note note = new Note(title, UUID.randomUUID().toString(), user);
        notes.add(note);
    }

    public void delete(String id) {
        notes.remove(getNote(id));
    }

    public void editText(String id, String replaceText) {
        if(getNote(id) != null){
            getNote(id).setText(replaceText);
        }

    }

    public ArrayList<Note> savedNote(User user){
        ArrayList<Note> userNotes = new ArrayList<>();
        for(Note note : notes){
            if(note.getUser().equals(user)){
                userNotes.add(note);
            }
        }
        return userNotes;
    }

    private Note getNote(String id) {
        for (Note note : notes) {
            if (note.getId().equals(id)) {
                return note;
            }
        }
        return null;
    }

}
