package com.example.springgprcserver.com.hzhf.server;

import com.hzhf.demo.proto.UserGrpc;
import com.hzhf.demo.proto.UserGrpc.UserImplBase;
import com.hzhf.demo.proto.UserOuterClass;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
//import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
//import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
//import net.devh.boot.grpc.server.service.GrpcService;

import java.util.HashMap;
import java.util.Map;

@GrpcService
public class UserService extends UserImplBase {

    private final Map<Integer, UserOuterClass.UserData> userDataMap = new HashMap<>();

    @Override
    public void getUser(UserOuterClass.UserRequest request, StreamObserver<UserOuterClass.UserData> responseObserver) {
        UserOuterClass.UserData user = userDataMap.get(request.getId());
        responseObserver.onNext(user);
        responseObserver.onCompleted();
    }

    @Override
    public void saveUser(UserOuterClass.UserData request, StreamObserver<UserOuterClass.UserResponse> responseObserver) {
        userDataMap.put(request.getId(), request);
        responseObserver.onNext(UserOuterClass.UserResponse.newBuilder().setIsSuccess(true).build());
        responseObserver.onCompleted();
    }
}
