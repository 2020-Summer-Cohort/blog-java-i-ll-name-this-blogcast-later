package org.wcci.blog;

import javax.persistence.*;
import java.time.LocalDateTime;

import java.util.Set;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private Set<Author> authors;
    private LocalDateTime publishDate;
    private Set<Category> categories;
    private Set<Tag> tags;

    protected Post(){}

    public Post(String title, String description, Set<Author> authors, LocalDateTime publishDate, Set<Category> categories, Set<Tag> tags) {
        this.title = title;
        this.description = description;
        this.authors = authors;
        this.publishDate = publishDate;
        this.categories = categories;
        this.tags = tags;
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

    public Set<Author> getAuthors() {
        return authors;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Set<Tag> getTags() {
        return tags;
    }
}
