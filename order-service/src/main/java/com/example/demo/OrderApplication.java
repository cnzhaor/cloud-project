package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/orders")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @GetMapping("/{id}")
    public String getOrder(@PathVariable Long id) {
        // 模拟随机延迟
        if (Math.random() > 0.7) {
            throw new RuntimeException("模拟服务异常");
        }
        return "订单号：" + id + "（order-service 返回）";
    }
}
