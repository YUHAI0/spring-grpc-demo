package com.example.springgrpcclient.controller;

import com.example.springgrpcclient.bean.UserBean;
import com.example.springgrpcclient.service.UserClientService;
import com.hzhf.demo.proto.UserOuterClass;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

//@RequestMapping("/")
@RestController
public class DemoController {

    @Resource
    UserClientService userClientService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    private String hello() {
        return "hello, world";
    }

    @PostMapping("/addUser")
    private String addUser(@RequestBody UserBean user) {
        UserOuterClass.UserData userData =
                UserOuterClass.UserData.newBuilder()
                        .setAge(user.getAge())
                        .setName(user.getName())
                        .setSex(user.getSex())
                        .setRemark(user.getRemark())
                        .buildPartial();
        if (userClientService.saveUser(userData)) {
            return "ok";
        } else {
            return "fail";
        }
    }

    @GetMapping("/user/{id}")
    private UserBean getUser(@PathVariable int id) {
        UserOuterClass.UserData userData = userClientService.getUserData(id);
        return new UserBean(
                userData.getId(),
                userData.getName(),
                userData.getSex(),
                userData.getAge(),
                userData.getRemark());
    }

}
