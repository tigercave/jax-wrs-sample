package com.cuongnt.client;

import com.cuongnt.client.stub.ServerInfo;
import com.cuongnt.client.stub.ServerInfoService;

public class WSClient {
	public static void main(String[] args) {
		
		ServerInfoService service = new ServerInfoService();
		ServerInfo port = service.getServerInfoPort();
		
		System.out.println(port.getServerName());
	}
}
