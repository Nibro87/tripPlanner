package entities;


import javax.persistence.*;
import java.util.List;

@Entity
public class Wall {

    @Id
    @Column(name = "wall_id", nullable = false)


    private Long id;





    @OneToOne
    User user;


    String message;
    String ArticleUrl;

    public Wall() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getArticleUrl() {
        return ArticleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        ArticleUrl = articleUrl;
    }
}
