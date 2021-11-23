package entities;




import entities.User;

import javax.persistence.*;

@Entity
public class Comments {


    @Id
    @Column(name = "comment_id", nullable = false)
    private Long id;

    String message;

    @ManyToOne
    User user;

    public Comments() {
    }

    public Comments(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Comments(Long id, String message, User user) {
        this.id = id;
        this.message = message;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", user=" + user +
                '}';
    }
}

