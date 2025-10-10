package com.example.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduledTasks {

    // 每5秒执行一次
    @Scheduled(fixedRate = 5000)
    public void task1() {
        System.out.println("fixedRate 执行: " + LocalDateTime.now());
    }

    // 每天凌晨1点执行
    @Scheduled(cron = "0 0 1 * * ?")
    public void task2() {
        System.out.println("cron 定时任务执行: " + LocalDateTime.now());
    }
}
