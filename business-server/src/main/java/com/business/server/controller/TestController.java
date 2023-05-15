package com.business.server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : xlx
 * @Description :
 * @Date: 2023/5/10
 */
@RestController
public class TestController {

    @Value("${name}")
    private String name;

    @GetMapping("/test")
    public String test(){
        return name;
    }

}
