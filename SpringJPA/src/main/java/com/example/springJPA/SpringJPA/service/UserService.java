package com.example.springJPA.SpringJPA.service;

import com.example.springJPA.SpringJPA.dto.UserDTO;
import com.example.springJPA.SpringJPA.exceptions.UserNotFoundException;
import com.example.springJPA.SpringJPA.model.User;
import com.example.springJPA.SpringJPA.repository.UserRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    // metoda per gjetjen e te gjithe userve
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    //metoda per gjetjen e user sipas email
    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    // metoda per te fshire nje perdorues nga databaza
    public void deleteUserById(Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException("Perdoruesi me id: " + id + " nuk u gjet");
        }
    }

    // metoda per update e nje user
    public User updateUser(Long id, User updatedUser){
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setName(updatedUser.getName());
                    existingUser.setEmail(updatedUser.getEmail());
                    return userRepository.save(existingUser);
                }).orElseThrow(() -> new UserNotFoundException("Nuk ekziston"));
    }

    public long count() {
        return userRepository.count();
    }
}
