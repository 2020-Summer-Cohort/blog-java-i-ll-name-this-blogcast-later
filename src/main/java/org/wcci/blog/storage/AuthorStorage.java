package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Author;
import org.wcci.blog.repositories.AuthorRepository;

import java.util.Optional;

@Service
public class AuthorStorage {

    private AuthorRepository authorRepository;

    public AuthorStorage(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void save(Author authorToSave) {
        authorRepository.save(authorToSave);
    }

    public Iterable<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public Optional<Author> findAuthorById(Long id) {
        return authorRepository.findById(id);
    }

}
