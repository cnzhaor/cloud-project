package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String hello() {
        log.info("调用 /hello 接口");
        return "Hello, Spring Boot!";
    }

    @GetMapping("/test-error")
    public String error() {
        log.error("准备抛出自定义异常");
        throw new BizException("这是一个自定义业务异常！");
    }

    @GetMapping("/hello2")
    public String hello2(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //path参数
    @GetMapping("/hello/{name}")
    public String helloPath(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        // 可以在这里做业务逻辑，比如保存数据库
        return person; // Spring Boot 自动返回 JSON
    }


}
