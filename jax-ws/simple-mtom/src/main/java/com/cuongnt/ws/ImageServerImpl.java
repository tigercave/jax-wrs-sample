package com.cuongnt.ws;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

@MTOM
@WebService(endpointInterface = "com.cuongnt.ws.ImageServer", portName = "ImageWS", serviceName = "ImageService")
public class ImageServerImpl implements ImageServer {

	@Override
	public Image downloadImage(String name) {
		
		try {
			 
			File image = new File("C:\\images\\" + name);
			return ImageIO.read(image);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String uploadImage(Image data) {
		
		if (data != null) {
			
			return "Upload image successfull";
		}
		
		throw new WebServiceException("Upload Failed");
	}

}
