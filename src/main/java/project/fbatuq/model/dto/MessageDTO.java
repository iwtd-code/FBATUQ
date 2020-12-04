package project.fbatuq.model.dto;

import java.sql.Timestamp;

public class MessageDTO {
    private Long id;
    private String text;
    private Timestamp timestamp;

    @Override
    public String toString() {
        return "MessageDTO{" +
                "text='" + text + '\'' +
                ", creatingDate=" + timestamp +
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
}
