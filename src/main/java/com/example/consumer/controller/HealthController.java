package com.example.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author wangguangyuan
 * @Date 2024-07-28 16:04
 */
@RestController
@RequestMapping(value = "/health")
public class HealthController {

    @RequestMapping(value = "/check")
    public void healthCheck() {
        System.out.println("health check");
    }
}
