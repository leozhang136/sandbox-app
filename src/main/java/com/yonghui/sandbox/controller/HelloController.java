package com.yonghui.sandbox.controller;

import com.yonghui.sandbox.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: TODO
 * @author: zhangtong
 * @create: 2021-02-05 10:31
 **/
@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final String templateName = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = "/getUser/{name}")
    public Object getUser(@PathVariable String name){
        UserModel userModel = new UserModel(counter.incrementAndGet(), String.format(templateName, name), new Date());
        return userModel;
    }

    @GetMapping(value = "/get")
    public Object get(String name){
        UserModel userModel = new UserModel(counter.incrementAndGet(), String.format(templateName, name), new Date());
        return userModel;
    }

}
