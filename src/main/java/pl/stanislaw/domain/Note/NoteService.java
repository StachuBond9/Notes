package pl.stanislaw.domain.Note;

import pl.stanislaw.domain.User.User;
import pl.stanislaw.domain.User.UserRepository;

import java.util.ArrayList;
import java.util.UUID;

public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    public void createNote(String title, User user) {
        Note note = new Note(title, "", UUID.randomUUID().toString(), user);
        noteRepository.addNote(note);
    }

    public void delete(String id) {
        noteRepository.removeNote(getNote(id));
    }

    public void editText(String id, String replaceText) {
        if(getNote(id) != null){
            noteRepository.editText(replaceText, getNote(id));

        }

    }

    public ArrayList<Note> savedNote(User user){
        ArrayList<Note> userNotes = new ArrayList<>();
        for(Note note : noteRepository.noteList()){
            if(note.user().equals(user)){
                userNotes.add(note);
            }
        }
        return userNotes;
    }

    private Note getNote(String id) {
        for (Note note : noteRepository.noteList()) {
            if (note.id().equals(id)) {
                return note;
            }
        }
        return null;
    }

}
