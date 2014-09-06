package com.cuongnt.app;

import com.cuongnt.wsclient.HelloWorld;
import com.cuongnt.wsclient.HelloWorldImplService;

public class Main {
	
	public static void main(String[] args) {
		
		HelloWorldImplService service = new HelloWorldImplService();
		
		HelloWorld helloWorld = service.getHelloWorldImplPort();
		
		System.out.println(helloWorld.getHelloWorldAsString("Nguyen Duc Duong"));

	}
}
