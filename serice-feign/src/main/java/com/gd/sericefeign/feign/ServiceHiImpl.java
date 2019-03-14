package com.gd.sericefeign.feign;

import org.springframework.stereotype.Component;

@Component
public class ServiceHiImpl implements ServiceHi {
    @Override
    public String homeHi(String name) {
        return "ssss,"+name+"error";
    }
}
