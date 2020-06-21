package org.wcci.blog;

import javax.persistence.*;
import java.time.LocalDateTime;

import java.util.Collection;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    @ManyToMany
    private Collection<Author> authors;
    private LocalDateTime publishDate;
    private Collection<Category> categories;
    private Collection<Tag> tags;

    protected Post(){}

    public Post(String title, String description, Collection<Author> authors, LocalDateTime publishDate, Collection<Category> categories, Collection<Tag> tags) {
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

    public Collection<Author> getAuthors() {
        return authors;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

    public Collection<Tag> getTags() {
        return tags;
    }
}
