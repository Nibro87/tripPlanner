package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class SharedArticles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String urlToImage;
    String url;
    String title;
    String publishedAt;
    String description;
    String postArticle;

    public SharedArticles() {
    }

    public SharedArticles(String urlToImage, String url, String title, String publishedAt, String description, String postArticle) {
        this.urlToImage = urlToImage;
        this.url = url;
        this.title = title;
        this.publishedAt = publishedAt;
        this.description = description;
        this.postArticle = postArticle;
    }
    public SharedArticles(SharedArticles article, User user) {
        if(article.getId() != null){
            this.id = article.getId();
        }
        this.urlToImage = article.getUrlToImage();
        this.url = article.getUrl();
        this.title = article.getTitle();
        this.publishedAt = article.getPublishedAt();
        this.description = article.getDescription();
        this.postArticle = article.getPostArticle();
        this.user = new User(user);

    }

    public SharedArticles(String urlToImage, String url, String title, String publishedAt, String description, String postArticle, User user) {
        this.urlToImage = urlToImage;
        this.url = url;
        this.title = title;
        this.publishedAt = publishedAt;
        this.description = description;
        this.postArticle = postArticle;
        this.user = user;
    }

    public SharedArticles(Long id, String urlToImage, String url, String title, String publishedAt, String description, String postArticle) {
        this.id = id;
        this.urlToImage = urlToImage;
        this.url = url;
        this.title = title;
        this.publishedAt = publishedAt;
        this.description = description;
        this.postArticle = postArticle;
    }

    @ManyToOne()
    @JoinColumn(name = "USER_user_name")
    User user;


    public Long getId() { return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostArticle() { return postArticle;}

    public void setPostArticle(String postArticle) { this.postArticle = postArticle;}

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", urlToImage='" + urlToImage + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", description='" + description + '\'' +
                ", postArticle='" + postArticle + '\'' +
                '}';
    }


}