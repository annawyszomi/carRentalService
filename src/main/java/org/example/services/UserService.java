package org.example.services;

import org.example.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void add(User user);
    void delete(Long id);
    Optional<User> findById(Long id);
    List<User> findAll();
}
