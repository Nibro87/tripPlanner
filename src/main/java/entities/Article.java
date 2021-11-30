package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String urlToImage;
    String url;
    String title;
    String publishedAt;
    String description;
    String Comment;

    public Article() {
    }

    public Article(String urlToImage, String url, String title, String publishedAt, String description, String comment) {
        this.urlToImage = urlToImage;
        this.url = url;
        this.title = title;
        this.publishedAt = publishedAt;
        this.description = description;
        Comment = comment;
    }

    public Long getId() {
        return id;
    }

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

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", urlToImage='" + urlToImage + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}