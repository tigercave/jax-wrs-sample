package com.cuongnt.client;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.cuongnt.ws.ImageServer;

public class ImageClient {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://localhost:9999/ws/image?wsdl");
		QName qName = new QName("http://ws.cuongnt.com/", "ImageService");
		
		Service service = Service.create(url, qName);
		ImageServer imageServer = service.getPort(ImageServer.class);
		
		/* Test download */
		Image image = imageServer.downloadImage("image.jpg");
		image = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		
		// display it in frame.
		JFrame frame = new JFrame();
		frame.setSize(300, 300);
		JLabel label = new JLabel(new ImageIcon(image));
		frame.add(label);
		frame.setVisible(true);
		
		System.out.println("[ServerImage] downloadImage() : Download Successfully!");
	}
}
