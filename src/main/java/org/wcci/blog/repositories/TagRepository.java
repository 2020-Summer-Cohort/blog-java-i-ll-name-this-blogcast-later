package org.wcci.blog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.entities.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {
}
