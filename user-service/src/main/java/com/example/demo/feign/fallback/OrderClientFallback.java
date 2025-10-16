package com.example.demo.feign.fallback;

import com.example.demo.feign.OrderClient;
import org.springframework.stereotype.Component;

@Component
public class OrderClientFallback implements OrderClient {
    @Override
    public String getOrderById(Long id) {
        return "服务暂时不可用，请稍后再试（熔断降级）";
    }
}
