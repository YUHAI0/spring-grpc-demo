package com.example.springgrpcclient.service;

import com.alibaba.fastjson.JSON;
import com.hzhf.demo.proto.UserGrpc;
import com.hzhf.demo.proto.UserOuterClass;
import io.grpc.Channel;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;


@Service
//@Slf4j
public class UserClientService {
    @GrpcClient("local-grpc-server")
    private Channel serverChannel;

    public boolean saveUser(UserOuterClass.UserData userData) {
        UserGrpc.UserBlockingStub userBlockingStub = UserGrpc.newBlockingStub(serverChannel);
        System.out.println(JSON.toJSONString(userData));
        UserOuterClass.UserResponse response = userBlockingStub.saveUser(userData);
        return response.getIsSuccess();
    }

    public UserOuterClass.UserData getUserData(int id) {
        UserGrpc.UserBlockingStub userBlockingStub = UserGrpc.newBlockingStub(serverChannel);
        UserOuterClass.UserData userData = userBlockingStub.getUser(UserOuterClass.UserRequest.newBuilder().setId(id).build());
        System.out.println(JSON.toJSONString(userData));
        return userData;

    }
}
