package com.gd.serviceribbon.controller;

import com.gd.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther guodong
 * @email https://github.com/guodong94
 * @date 2019/2/20 0:04
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @GetMapping(value = "/h1")
    public String hi(@RequestParam String name) {
        return helloService.hiService( name );
    }
}
