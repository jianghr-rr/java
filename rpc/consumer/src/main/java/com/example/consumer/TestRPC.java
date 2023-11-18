package com.example.consumer;

import com.example.consumer.rpc.consumer.SkuService;
import com.example.consumer.rpc.consumer.UserService;
import com.example.consumer.rpc.consumerStub.HeroRPCProxy;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestRPC {

	public static void main(String[] args) {
		// RPC 跨服务，跨进程的方法调用
		// 第1次远程调用
		SkuService skuService=(SkuService)
				HeroRPCProxy.create(SkuService.class);
		System.out.println(skuService.findByName("uid"));
//第2次远程调用
		UserService userService = (UserService)
				HeroRPCProxy.create(UserService.class);
		System.out.println(userService.findById());
	}
}
