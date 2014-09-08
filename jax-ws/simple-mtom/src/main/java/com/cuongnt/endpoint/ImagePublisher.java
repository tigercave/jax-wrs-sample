package com.cuongnt.endpoint;

import javax.xml.ws.Endpoint;

import com.cuongnt.ws.ImageServerImpl;

public class ImagePublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/ws/image", new ImageServerImpl());
		System.out.println("Server is pushlished!");
	}
}
