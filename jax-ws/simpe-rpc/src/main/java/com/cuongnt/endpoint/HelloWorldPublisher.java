package com.cuongnt.endpoint;

import javax.xml.ws.Endpoint;

import com.cuongnt.ws.HelloWorldImpl;

// Endpoint Publisher
public class HelloWorldPublisher {
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
	}

}
