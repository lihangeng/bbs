package com.bbs.webServiceTest;

import java.util.Date;

import javax.jws.WebService;

@WebService(endpointInterface="com.bbs.webServiceTest.HelloWorld",serviceName="HelloWorlds")
public class HelloWorlds implements HelloWorld{

	public String sayHi(String name) {
		return name+"���ã����ڵ�ʱ���ǣ�"+new Date();
	}

}
