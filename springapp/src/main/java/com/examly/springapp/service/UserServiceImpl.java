package com.examly.springapp.service;

import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Page<User> getAllUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        return userRepo.findAll(pageable);
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = userRepo.findById(id).orElse(null);

        if (existingUser == null) return null;

        if (user.getUsername() != null)
            existingUser.setUsername(user.getUsername());

        if (user.getFullName() != null)
            existingUser.setFullName(user.getFullName());

        if (user.getEmail() != null)
            existingUser.setEmail(user.getEmail());

        if (user.getRole() != null)
            existingUser.setRole(user.getRole());

        return userRepo.save(existingUser);
    }

    @Override
    public List<User> getUsersByRole(String role) {
        return userRepo.findByRole(role);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email).orElse(null);
    }
}
