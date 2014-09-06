package com.cuongnt.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/* Webservice endpoint interfaces */
@WebService
@SOAPBinding(style = Style.RPC)
public interface HelloWorld {
	
	@WebMethod String getHelloWorldAsString(@WebParam(name = "name") String name);
	
}
