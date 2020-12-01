package project.fbatuq.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Timestamp creatingDate;
    @ManyToOne
    private User user;

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

    public Timestamp getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(Timestamp creatingDate) {
        this.creatingDate = creatingDate;
    }
}
