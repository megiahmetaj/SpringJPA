package com.example.springJPA.SpringJPA.service;

import com.example.springJPA.SpringJPA.model.User;
import com.example.springJPA.SpringJPA.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // metoda qe kerkon sipas emrit

}
