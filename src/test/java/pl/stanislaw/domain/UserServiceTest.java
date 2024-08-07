package pl.stanislaw.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.stanislaw.domain.User.UserService;

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
        Assertions.assertEquals(userService.registeredUsers().getFirst().login(), login);
        Assertions.assertEquals(userService.registeredUsers().getFirst().name(), name);
        Assertions.assertEquals(userService.registeredUsers().getFirst().password(), password);
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
        Assertions.assertEquals( userService.loggedUser().name() , name );
        Assertions.assertEquals( userService.loggedUser().login() , login );
        Assertions.assertEquals( userService.loggedUser().password() , password );
    }

}