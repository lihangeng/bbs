package com.bbs.webServiceTest;

import javax.xml.ws.Endpoint;

public class ServiceMain {

	public static void main(String[] args) {

		HelloWorld hw = new HelloWorlds();
		Endpoint.publish("http://192.168.1.100/vashon", hw);
		System.out.println("WebService±©Â¶³É¹¦");
	}

}
