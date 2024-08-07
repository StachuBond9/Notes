package pl.stanislaw.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class UserServiceTest {
    @Test
    void isUserRegisteredTest() {
        //given
        String name ="Jan";
        String login ="jan12";
        String password = "jan123";
        UserService userService = new UserService();


        //when
        userService.registration(name , login , password);

        //then
        Assertions.assertEquals(userService.registeredUsers().getFirst().getLogin(), login);
        Assertions.assertEquals(userService.registeredUsers().getFirst().getName(), name);
        Assertions.assertEquals(userService.registeredUsers().getFirst().getPassword(), password);
    }

    @Test
    void isUserLoggedTest() {
        //given
        String name ="Jan";
        String login ="jan12";
        String password = "jan123";
        UserService userService = new UserService();
        userService.registration(name , login , password);

        //when
        userService.login(login , password);

        //then
        Assertions.assertEquals( userService.loggedUser().getName() , name );
        Assertions.assertEquals( userService.loggedUser().getLogin() , login );
        Assertions.assertEquals( userService.loggedUser().getPassword() , password );
    }

}