package pl.stanislaw.domain.User;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class UserRepositoryInFile implements UserRepository {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ArrayList<User> users() {

        ArrayList<User> users = new ArrayList<>();
        try {
            users = objectMapper.readValue(new File("users.json"), new TypeReference<ArrayList<User>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User addUser(User user)  {
        ArrayList<User > users = users();
        users.add(user);

        try {
            objectMapper.writeValue(new File("users.json"),users );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void deleteAll() {
        try {
            objectMapper.writeValue(new File("users.json"),"[]" );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
