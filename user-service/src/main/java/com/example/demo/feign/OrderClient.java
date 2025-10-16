package com.example.demo.feign;

import com.example.demo.feign.fallback.OrderClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-service", url = "http://localhost:8082", fallback = OrderClientFallback.class)
public interface OrderClient {

    @GetMapping("/orders/{id}")
    String getOrderById(@PathVariable("id") Long id);
}
