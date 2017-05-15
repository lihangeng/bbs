package com.bbs.webServiceTest;

import java.util.Date;

import javax.jws.WebService;

@WebService(endpointInterface="com.bbs.webServiceTest.HelloWorld",serviceName="HelloWorlds")
public class HelloWorlds implements HelloWorld{

	public String sayHi(String name) {
		return name+"您好！现在的时间是："+new Date();
	}

}
