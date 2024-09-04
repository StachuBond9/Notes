package pl.stanislaw.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.stanislaw.domain.Note.*;
import pl.stanislaw.domain.User.User;
import pl.stanislaw.domain.User.UserRepository;
import pl.stanislaw.domain.User.UserRepositorySQL;
import pl.stanislaw.domain.User.UserService;

import java.util.List;

class NoteServiceTest {

    NoteRepository noteRepository = new NoteRepositorySQL();
    NoteService noteService = new NoteService(noteRepository);
    UserRepository userRepository = new UserRepositorySQL();
    UserService userService = new UserService(userRepository);

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
        noteRepository.deleteAll();
    }

    @Test
    void isNoteCreatedTest() {
        //Given
        String title = "Numery telefonow";
        User user = userService.registration("jan", "jan123", "jan1234");
        //when
        noteService.createNote(title, user);

        //then
        Assertions.assertEquals(title, noteService.savedNote(user).getFirst().title());
    }

    @Test
    void isNoteDeletedTest() {
        //given
        String title = "Numery telefonow";
        User user = userService.registration("jan", "jan123", "jan1234");
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
        User user = userService.registration("jan", "jan123", "jan1234");
        noteService.createNote(title, user);
        String text = "aaaaaaa";

        //when
        noteService.editText(noteService.savedNote(user).getFirst(), text );

        //then
        Assertions.assertEquals(noteService.savedNote(user).getFirst().text() , text);
    }

    @Test
    void isNotesSavedTest() {
        //given
        String title = "Numery telefonow";
        User user = userService.registration("jan", "jan123", "jan1234");

        //when
        noteService.createNote(title, user);

        //then
        Assertions.assertEquals(noteService.savedNote(user).getFirst().title(), title);
    }

    @Test
    void  isNoteGottenByTitleTest(){
        //given
        String title = "Numery telefonow";
        User user = userService.registration("jan", "jan123", "jan1234");
        noteService.createNote(title, user);
        String content = "Nu";

        //when
        List<Note> note = noteService.getNotesByTitle(content , user);

        //then
        Assertions.assertEquals(noteService.savedNote(user).getFirst(), note.getFirst());
    }

    @Test
    void  isNoteGottenByTextTest(){
        //given
        String title = "Numery telefonow";
        User user = userService.registration("jan", "jan123", "jan1234");
        noteService.createNote(title, user);
        noteService.editText(noteService.savedNote(user).getFirst(), "maszyna" );
        String content = "ma";

        //when
        List<Note> note = noteService.getNotesByContainedText(content , user);

        //then
        Assertions.assertEquals(noteService.savedNote(user).getFirst(), note.getFirst());
    }

    @Test
    void  isNoteSortedTest(){
        //given
        String title = "Numery telefonow";
        String title1 = "Mutter";
        User user = userService.registration("jan", "jan123", "jan1234");
        noteService.createNote(title, user);
        noteService.createNote(title1, user);

        //when
        List<Note> note = noteService.sortNotesByTitle(user);

        //then
        Assertions.assertEquals(note.getFirst().title(), title1 );
    }
}