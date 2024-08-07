package pl.stanislaw.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.stanislaw.domain.Note.NoteService;
import pl.stanislaw.domain.User.User;

class NoteServiceTest {

    NoteService noteService = new NoteService();
    @Test
    void isNoteCreatedTest() {
        //Given
        String title = "Numery telefonow";
        User user = new User("jan",  "jan123", "jan123");
        //when
        noteService.createNote(title, user);

        //then
        Assertions.assertEquals(noteService.savedNote(user).get(0).getTitle() , title);
    }

    @Test
    void isNoteDeletedTest() {
        //given
        String title = "Numery telefonow";
        User user = new User("jan",  "jan123", "jan123");
        noteService.createNote(title, user);

        //when
        noteService.delete(noteService.savedNote(user).getFirst().getId());

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
        noteService.editText(noteService.savedNote(user).getFirst().getId(), text );

        //then
        Assertions.assertEquals(noteService.savedNote(user).getFirst().getText() , text);
    }

    @Test
    void isNotesSavedTest() {
        String title = "Numery telefonow";
        User user = new User("jan",  "jan123", "jan123");
        noteService.createNote(title, user);

        Assertions.assertEquals(noteService.savedNote(user).getFirst().getTitle(), title);
    }
}