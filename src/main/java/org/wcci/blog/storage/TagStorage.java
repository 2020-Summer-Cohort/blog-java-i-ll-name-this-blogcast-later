package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Tag;
import org.wcci.blog.repositories.TagRepository;

@Service
public class TagStorage {

    private TagRepository tagRepository;

    public TagStorage(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag findTagByName(String name){
        return tagRepository.findByName(name);
    }

    public Iterable<Tag> findAllTags(){
        return tagRepository.findAll();
    }

    public void save(Tag tagToSave) {
        tagRepository.save(tagToSave);
    }
}
