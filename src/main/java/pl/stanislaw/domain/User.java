package pl.stanislaw.domain;

public class User {
    private final String name;
    private final String login;
    private final String password;

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() { return password; }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
