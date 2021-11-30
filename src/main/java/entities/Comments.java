package entities;




import entities.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false)
    private Long id;

    String message;



    public Comments() {
    }


    public Comments(String message) {
        this.message = message;
    }

    public Comments(Long id, String message) {
        this.id = id;
        this.message = message;
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
                '}';
    }




}

