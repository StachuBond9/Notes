package pl.stanislaw.domain.User;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) throws IOException {
        /*/
        User user1 = new User("Jan" , "jan12", "jan123");
        User user2 = new User("Jannina" , "janina12", "janina123");
        User user3 = new User("Janusz" , "janusz12", "janusz123");
        ArrayList<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(new File("users.json") , list);

        */

        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<User> users = objectMapper.readValue(new File("users.json"), new TypeReference<ArrayList<User>>() {
        });
        System.out.println(users);
    }
}

