package pl.stanislaw.domain.Note;

import pl.stanislaw.domain.User.User;
import pl.stanislaw.domain.User.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NoteService {

    private final NoteRepository noteRepository;
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    public List<Note> getNotesByTitle(String title, User user){
        return noteRepository.noteList().stream()
                .filter(note -> note.user().equals(user))
                .filter(note -> note.title().toLowerCase().contains(title.toLowerCase()))
                .toList();
    }
    public List<Note> sortNotesByTitle(User user){
        return noteRepository.noteList().stream()
                .filter(note -> note.user().equals(user))
                .sorted(((o1, o2) -> o1.title().compareTo(o2.title())))
                .toList();
    }
    public List<Note> getNotesByContainedText(String content, User user){
        return noteRepository.noteList().stream()
                .filter(note -> note.user().equals(user))
                .filter(note -> note.text().toLowerCase().contains(content.toLowerCase()))
                .toList();
    }

    public List<String> mapNotesToText(User user){
        return noteRepository.noteList().stream()
                .filter(note -> note.user().equals(user))
                .map(Note::toString)
                .toList();
    }

    public void createNote(String title, User user) {
        Note note = new Note(title, "", UUID.randomUUID().toString(), user);
        noteRepository.addNote(note);
    }

    public void delete(Note note) {
        noteRepository.removeNote(note);
    }

    public void editText(Note note, String replaceText) {
        if(note != null){
            noteRepository.editText(replaceText, note);

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


}
