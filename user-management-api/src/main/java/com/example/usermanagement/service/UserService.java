package com.example.usermanagement.service;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.exception.NotFoundException;
import com.example.usermanagement.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found: " + id));
    }

    public User create(User user) {
        if (user.getId() != null) {
            throw new IllegalArgumentException("New user cannot already have an ID");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        return userRepository.save(user);
    }

    public User update(Long id, User update) {
        User existing = findById(id);
        if (!existing.getEmail().equals(update.getEmail()) && userRepository.existsByEmail(update.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        existing.setName(update.getName());
        existing.setEmail(update.getEmail());
        existing.setRole(update.getRole());
        return userRepository.save(existing);
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException("User not found: " + id);
        }
        userRepository.deleteById(id);
    }
}
