package com.examly.springapp.service;

import com.examly.springapp.model.User;
import org.springframework.data.domain.Page;
import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    Page<User> getAllUsers(int page, int size);

    User getUserById(Long id);

    User updateUser(Long id, User user);

    List<User> getUsersByRole(String role);

    User getUserByEmail(String email);
}
