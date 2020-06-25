package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Post;
import org.wcci.blog.repositories.PostRepository;


@Service
public class PostStorage {

    private PostRepository postRepository;

    public PostStorage(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findPostByTitle(String title){
        return postRepository.findByTitle(title);
    }

    public Iterable<Post> findAllPosts(){
        return postRepository.findAll();
    }

    public void save(Post postToSave) {
        postRepository.save(postToSave);
    }
}
