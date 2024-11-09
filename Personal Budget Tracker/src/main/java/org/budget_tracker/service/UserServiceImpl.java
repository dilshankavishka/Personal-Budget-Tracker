package org.budget_tracker.service;

import lombok.RequiredArgsConstructor;
import org.budget_tracker.dto.User;
import org.budget_tracker.entity.UserEntity;
import org.budget_tracker.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository repository;
    private final ModelMapper mapper;
    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        repository.findAll().forEach(entity ->{
            userList.add(mapper.map(entity, User.class));
        });
        return userList;
    }

    @Override
    public void addUser(User user) {
        repository.save(mapper.map(user, UserEntity.class));
    }

    @Override
    public void deleteUserByUsername(String username) {
        repository.deleteById(username);
    }

    @Override
    public User searchUserByUsername(String username) {
        return mapper.map(repository.findById(username), User.class);
    }

    @Override
    public void updateUserByUsername(User user) {
        repository.save(mapper.map(user,UserEntity.class));
    }
}
