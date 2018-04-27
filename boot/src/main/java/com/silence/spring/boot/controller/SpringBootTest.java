package com.silence.spring.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Silence on 2018/4/27.
 */
@RestController
@RequestMapping("/springBoot")
public class SpringBootTest {

    @RequestMapping("/test")
    public String springBootTest() {

        return "Hello Spring Boot！";

    }

}
