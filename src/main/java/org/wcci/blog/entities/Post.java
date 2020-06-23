package org.wcci.blog.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    private Author author;
    private LocalDateTime publishDate;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Tag tag;

    protected Post(){}

    public Post(String title, String description, Author author, LocalDateTime publishDate, Category category, Tag tag) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.publishDate = publishDate;
        this.category = category;
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Author getAuthor() {
        return author;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public Category getCategory() {
        return category;
    }

    public Tag getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author=" + author +
                ", publishDate=" + publishDate +
                ", category=" + category +
                ", tag=" + tag +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        return id != null ? id.equals(post.id) : post.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
