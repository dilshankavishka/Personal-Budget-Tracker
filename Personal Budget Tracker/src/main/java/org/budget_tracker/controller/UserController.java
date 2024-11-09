package org.budget_tracker.controller;

import lombok.RequiredArgsConstructor;
import org.budget_tracker.dto.User;
import org.budget_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    @Autowired
    final UserService service;

    @GetMapping("/get-all")
    public List<User> getUser(){
        return service.getAll();
    }
    @PostMapping("/add-user")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user){
        service.addUser(user);
    }
    @GetMapping("/search-by-username/{username}")
    public User getUserByUsername(@PathVariable String username){
        return service.searchUserByUsername(username);
    }
    @DeleteMapping("/delete-by-username/{username}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUserByUsername(@PathVariable String username){
        service.deleteUserByUsername(username);
    }
    @PutMapping("/update-expense")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUserByUsername(@RequestBody User user){
        service.updateUserByUsername(user);
    }
}
