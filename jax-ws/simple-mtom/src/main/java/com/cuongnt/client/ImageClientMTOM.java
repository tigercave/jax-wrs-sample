package com.cuongnt.client;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.cuongnt.ws.ImageServer;

public class ImageClientMTOM {
	public static void main(String[] args) throws IOException {
		
		URL url = new URL("http://localhost:9999/ws/image?wsdl");
		QName qName = new QName("http://ws.cuongnt.com/", "ImageService");
		
		Service service = Service.create(url, qName);
		ImageServer imageServer = service.getPort(ImageServer.class);
		
		/* Test upload */
		Image imgUpload = ImageIO.read(new File("c:\\images\\image.jpg"));
		
		// enable MTOM in client
		BindingProvider bindingProvider = (BindingProvider) imageServer;
		SOAPBinding soapBinding = (SOAPBinding) bindingProvider.getBinding();
		soapBinding.setMTOMEnabled(true);
		
		String status = imageServer.uploadImage(imgUpload);
		
		System.out.println("[ImageServer] uploadImage() : " + status);
	}
}
