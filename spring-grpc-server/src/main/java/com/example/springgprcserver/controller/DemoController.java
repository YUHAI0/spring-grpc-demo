package com.example.springgprcserver.controller;

import com.hzhf.demo.proto.UserOuterClass;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
//@RequestMapping("/")
public class DemoController {


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    private String hello() {
        return "hello, world";
    }



}
