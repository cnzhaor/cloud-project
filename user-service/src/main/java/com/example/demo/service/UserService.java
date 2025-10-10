package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(UserDTO userDTO);

    List<User> getAllUsers();

    Page<User> getUsersByPage(int page, int size, String sortBy, Boolean asc);

    List<User> getUsersByAge(int age);

    Optional<User> findById(Long id);

    User updateUser(Long id, UserDTO userDTO);

    void deleteById(Long id);

    void deleteAll();
}
