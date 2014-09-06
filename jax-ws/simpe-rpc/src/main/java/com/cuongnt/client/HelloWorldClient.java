package com.cuongnt.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.cuongnt.ws.HelloWorld;

public class HelloWorldClient {
	
	public static void main(String[] args) throws Exception {
		
		URL url = new URL("http://localhost:9999/ws/hello?wsdl");
		
		// 1st argument service URI, refer to wsdl document
		// 2nd argument is service name, refer to wsdl document
		QName qname = new QName("http://ws.cuongnt.com/", "HelloWorldImplService");
		
		Service service = Service.create(url, qname);
		
		HelloWorld helloWorld = service.getPort(HelloWorld.class);
		
		System.out.println(helloWorld.getHelloWorldAsString("Nguyen Trong Cuong"));
	}
}
