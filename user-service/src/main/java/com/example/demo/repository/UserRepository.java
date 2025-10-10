package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    // 自定义方法：查找年龄大于某值的用户
    List<User> findByAgeGreaterThan(int age);

}
