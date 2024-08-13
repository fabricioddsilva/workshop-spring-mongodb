package com.kaos.workshopmongo.resources;

import com.kaos.workshopmongo.entities.User;
import com.kaos.workshopmongo.entities.dto.UserDTO;
import com.kaos.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(UserDTO::new).toList();
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        return ResponseEntity.ok().body(new UserDTO(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO){
        User user = service.fromDTO(userDTO);
        user = service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
