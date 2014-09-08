package com.cuongnt.endpoint;

import javax.xml.ws.Endpoint;

import com.cuongnt.ws.ServerInfo;

public class WSPublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/ws/server", new ServerInfo());
		
		System.out.println("Service is publisher!");
	}
}
