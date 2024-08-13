package com.kaos.workshopmongo.services;

import com.kaos.workshopmongo.entities.Post;
import com.kaos.workshopmongo.repositories.PostRepository;
import com.kaos.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Optional<Post> post = repository.findById(id);
        if (post.isEmpty()){
            throw new ObjectNotFoundException(id);
        }
        return post.get();
    }

    public List<Post> findByTitle(String text){
        return repository.findByTitleContainingIgnoreCase(text);
    }
}
