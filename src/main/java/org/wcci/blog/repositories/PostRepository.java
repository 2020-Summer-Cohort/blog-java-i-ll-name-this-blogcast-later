package org.wcci.blog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.entities.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
    Post findByTitle(String title);
}
