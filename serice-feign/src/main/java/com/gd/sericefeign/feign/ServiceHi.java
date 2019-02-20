package com.gd.sericefeign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @auther guodong
 * @email https://github.com/guodong94
 * @date 2019/2/20 21:39
 */
@FeignClient(value = "service-hi")
@Component
public interface ServiceHi {

    @RequestMapping(value = "/h1",method = RequestMethod.GET)
    String homeHi(@RequestParam(value = "name") String name);
}
