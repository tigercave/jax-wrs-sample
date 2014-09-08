package com.cuongnt.ws;

import java.awt.Image;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

// Service endpoint interface
@WebService(name = "ImageServer")
@SOAPBinding(style = Style.RPC)
public interface ImageServer {
	
	// download a image from server
	@WebMethod Image downloadImage(String name);
	
	// upload image to server
	@WebMethod String uploadImage(Image data);
}
