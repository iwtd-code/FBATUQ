package project.fbatuq.model.dto;

import project.fbatuq.model.entity.User;

import java.sql.Timestamp;

public class MessageDTO {
    private Long id;
    private String text;
    private Timestamp timestamp;
    private User user;

    @Override
    public String toString() {
        return "MessageDTO{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", timestamp=" + timestamp +
                ", user=" + user +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
