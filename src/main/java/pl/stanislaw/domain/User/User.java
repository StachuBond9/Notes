package pl.stanislaw.domain.User;

public record User( Integer id, String name, String login, String password) {


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
