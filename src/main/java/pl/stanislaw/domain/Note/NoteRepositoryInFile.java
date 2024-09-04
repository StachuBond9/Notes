package pl.stanislaw.domain.Note;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.stanislaw.domain.User.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class NoteRepositoryInFile implements NoteRepository {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void addNote(Note note) {
        ArrayList<Note> notes = noteList();
        notes.add(note);

        try {
            objectMapper.writeValue(new File("notes.json"), notes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Note> noteList() {
        ArrayList<Note> notes = new ArrayList<>();
        try {
            notes = objectMapper.readValue(new File("notes.json"), new TypeReference<ArrayList<Note>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return notes;
        }
        return notes;
    }

    @Override
    public void removeNote(Note note) {
        ArrayList<Note> notes = noteList();
        notes.remove(note);
        try {
            objectMapper.writeValue(new File("notes.json"), notes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editText(String replaceText, Note note) {
        ArrayList<Note> notes = noteList();
        Note newNote = new Note(note.title(), replaceText, note.id(), note.user());
        notes.remove(note);
        notes.add(newNote);

        try {
            objectMapper.writeValue(new File("notes.json"), notes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAll() {

        try {
            objectMapper.writeValue(new File("notes.json"), "[]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
