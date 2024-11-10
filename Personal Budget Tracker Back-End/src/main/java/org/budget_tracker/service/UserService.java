package org.budget_tracker.service;

import org.budget_tracker.dto.Expense;
import org.budget_tracker.dto.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    void addUser(User user);
    void deleteUserByUsername(String username);
    User searchUserByUsername(String username);
    void updateUserByUsername(User user);
}
