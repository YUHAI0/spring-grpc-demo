package com.example.springgrpcclient.bean;

import com.hzhf.demo.proto.UserOuterClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBean {
//    string name = 2;
//    string sex = 3;
//    int32 age = 4;
//    string remark = 5;
    private int id = 0;
    private String name = "";
    private String sex = "male";
    private int age = 0;
    private String remark = "";
}
