package com.microservice.eureka.user.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @RequestMapping("/userClient")
    public String user() {
        return "用户服务";
    }
    @HystrixCommand(fallbackMethod = "fallbackGetOrder")
    @GetMapping("getOrder")
    public String getOrder(Integer id) {
        //String result = this.restTemplate().getForObject("http://localhost:8763/order", String.class);
        return  this.restTemplate().getForObject("http://localhost:8763/order", String.class);
    }

    public String fallbackGetOrder(Integer id) {
        return "服务错误";
    }
}
