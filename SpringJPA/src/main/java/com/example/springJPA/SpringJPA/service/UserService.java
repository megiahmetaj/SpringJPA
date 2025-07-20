package com.example.springJPA.SpringJPA.service;

import com.example.springJPA.SpringJPA.dto.UserDTO;
import com.example.springJPA.SpringJPA.model.User;
import com.example.springJPA.SpringJPA.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // metoda per te krijuar
    public User save (User user){
        return userRepository.save(user);
    }

    // metoda qe kerkon sipas emrit dhe kthen nje objekt userDTO
    public List<UserDTO> searchByName(String name){
        return userRepository.findByName(name)
                .stream().map(user -> new UserDTO(user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }



}
