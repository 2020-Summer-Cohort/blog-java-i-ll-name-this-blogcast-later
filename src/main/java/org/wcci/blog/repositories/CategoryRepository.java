package org.wcci.blog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findByName(String name);
}
