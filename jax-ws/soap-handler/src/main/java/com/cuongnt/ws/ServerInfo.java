package com.cuongnt.ws;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
@HandlerChain(file = "soaphandle/handle-chain.xml")
public class ServerInfo {
	
	@WebMethod
	public String getServerName() {
		return "CuongNT-PC";
	}

}
