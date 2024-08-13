package com.kaos.workshopmongo.services;

import com.kaos.workshopmongo.entities.User;
import com.kaos.workshopmongo.entities.dto.UserDTO;
import com.kaos.workshopmongo.repositories.UserRepository;
import com.kaos.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> user = repository.findById(id);
        if (user.isEmpty()){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user.get();
    }

    public User insert(User obj){
        return repository.insert(obj);
    }

    public User fromDTO (UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    public void delete(String id){
        if(!repository.existsById(id)){
            throw new ObjectNotFoundException(id);
        }
        repository.deleteById(id);
    }

    public User update(User user, String id){
        Optional<User> newUser = repository.findById(id);
        if(newUser.isEmpty()){
            throw new ObjectNotFoundException(id);
        }
        updateData(newUser.get(), user);
        return repository.save(newUser.get());
    }

    public void updateData(User newUser, User user){
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

}
