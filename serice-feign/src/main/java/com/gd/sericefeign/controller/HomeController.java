package com.gd.sericefeign.controller;

import com.gd.sericefeign.feign.ServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther guodong
 * @email https://github.com/guodong94
 * @date 2019/2/20 21:42
 */
@RestController
public class HomeController {
    @Autowired
    private ServiceHi serviceHi;
    @GetMapping(value = "/h1")
    public String sayHi(@RequestParam String name){
        return serviceHi.homeHi(name);
    }

}
