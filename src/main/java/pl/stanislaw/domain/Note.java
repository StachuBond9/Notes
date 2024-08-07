package pl.stanislaw.domain;

public class Note {
    private String title;
    private String text;
    private final String id;
    private final User user;

    public Note(String title, String id , User user) {
        this.title = title;
        this.id = id;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
