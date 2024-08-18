package pl.stanislaw.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.stanislaw.domain.Note.NoteRepository;
import pl.stanislaw.domain.Note.NoteRepositoryInMemory;
import pl.stanislaw.domain.Note.NoteService;
import pl.stanislaw.domain.User.User;
import pl.stanislaw.domain.User.UserRepository;

class NoteServiceTest {

    NoteRepository noteRepository = new NoteRepositoryInMemory();
    NoteService noteService = new NoteService(noteRepository);
    @Test
    void isNoteCreatedTest() {
        //Given
        String title = "Numery telefonow";
        User user = new User("jan",  "jan123", "jan123");
        //when
        noteService.createNote(title, user);

        //then
        Assertions.assertEquals(noteService.savedNote(user).getFirst().title(), title);
    }

    @Test
    void isNoteDeletedTest() {
        //given
        String title = "Numery telefonow";
        User user = new User("jan",  "jan123", "jan123");
        noteService.createNote(title, user);

        //when
        noteService.delete(noteService.savedNote(user).getFirst());

        //then
        Assertions.assertTrue(noteService.savedNote(user).isEmpty());
    }

    @Test
    void isTextEditedTest() {
        //given
        String title = "Numery telefonow";
        User user = new User("jan",  "jan123", "jan123");
        noteService.createNote(title, user);
        String text = "aaaaaaa";

        //when
        noteService.editText(noteService.savedNote(user).getFirst(), text );

        //then
        Assertions.assertEquals(noteService.savedNote(user).getFirst().text() , text);
    }

    @Test
    void isNotesSavedTest() {
        String title = "Numery telefonow";
        User user = new User("jan",  "jan123", "jan123");
        noteService.createNote(title, user);

        Assertions.assertEquals(noteService.savedNote(user).getFirst().title(), title);
    }
}