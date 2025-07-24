package com.example.springJPA.SpringJPA.controller;

import com.example.springJPA.SpringJPA.dto.UserDTO;
import com.example.springJPA.SpringJPA.model.User;
import com.example.springJPA.SpringJPA.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<UserDTO> searchUserByName(@RequestParam String name) {
        return userService.searchByName(name);
    }

//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        return userService.save(user);
//    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDTO userDTO){
        User user = new User(null, userDTO.getName(), userDTO.getEmail());
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build(); // 204 No content
    }
    //menyra e dyte
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public void deleteById(@PathVariable Long id){
//        userService.deleteUserById(id);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updatedUser(@PathVariable  Long id, @RequestBody User updatedUser){
        User user = userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/count")
    public long countUsers() {
        return userService.count();
    }
}