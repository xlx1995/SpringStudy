package com.business.server;

import com.base.server.annotation.EnableStarterService;
import org.springframework.boot.SpringApplication;

/**
 * @Author : xlx
 * @Description :
 * @Date: 2023/4/26
 */
@EnableStarterService
public class BusinessServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessServerApplication.class, args);
    }

}
