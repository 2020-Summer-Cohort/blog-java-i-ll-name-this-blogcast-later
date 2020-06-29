package org.wcci.blog.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany (mappedBy = "author")
    private Collection<Post> posts;

    public Author() {}

    public Author(String name, Post... posts) {
        this.name = name;
        this.posts = new ArrayList<>(Arrays.asList(posts));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Collection<Post> getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", posts=" + posts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return id != null ? id.equals(author.id) : author.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
