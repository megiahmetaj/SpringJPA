package com.example.springJPA.SpringJPA.controller;

import com.example.springJPA.SpringJPA.dto.UserDTO;
import com.example.springJPA.SpringJPA.model.User;
import com.example.springJPA.SpringJPA.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/search")
    public List<UserDTO> searchUserByName(@RequestParam String name){
        return userService.searchByName(name);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }
}
