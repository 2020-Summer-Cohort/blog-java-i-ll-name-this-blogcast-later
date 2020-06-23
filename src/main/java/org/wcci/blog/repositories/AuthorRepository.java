package org.wcci.blog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.entities.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author findByFullName(String firstName, String lastName);
}
