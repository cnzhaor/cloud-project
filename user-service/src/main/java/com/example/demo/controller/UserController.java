package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 保存用户
    @PostMapping("/create")
    public User createUser(@Valid @RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @GetMapping("/{id}")
    public Result<Optional<User>> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if (!user.isPresent()) {
            return Result.error("用户不存在");
        }
        return Result.success(user);
    }

    // 查询所有用户
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/page")
    public Page<User> getUsersByPage(@RequestParam int page,
                                     @RequestParam int size,
                                     @RequestParam String sortBy,
                                     @RequestParam(defaultValue = "true") boolean asc) {
        return userService.getUsersByPage(page, size, sortBy, asc);
    }


    // 查询年龄大于某值的用户
    @GetMapping("/age/{age}")
    public List<User> getUsersByAge(@PathVariable int age) {
        return userService.getUsersByAge(age);
    }


    // 更新用户
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }


    // 删除单个用户
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "Deleted user with id: " + id;
    }

    // 删除所有用户
    @DeleteMapping
    public String deleteAllUsers() {
        userService.deleteAll();
        return "Deleted all users";
    }
}
