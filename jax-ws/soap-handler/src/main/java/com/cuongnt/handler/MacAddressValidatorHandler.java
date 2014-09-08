package com.cuongnt.handler;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

public class MacAddressValidatorHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		
		System.out.println("[MacAddressValidatorHandler] handleMessage() .... ");
		
		Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		
		// for response messge only, true for outbound message, false for inbound
		if (!isRequest) {
			
			try {
				SOAPMessage message = context.getMessage();
				SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
				SOAPHeader header = message.getSOAPHeader();
				
				// if no header, add one
				if (header == null) {
					header = envelope.addHeader();
					// throw exception
					generateSOAPErrMessage(message, "No Soap Header");
				}
				
				// get client soap address from soap header
				@SuppressWarnings("rawtypes")
				Iterator it = header.examineHeaderElements(SOAPConstants.URI_SOAP_ACTOR_NEXT);
				
				// if no header block for next actor found? throw exception
				if (it == null || !it.hasNext()) {
					generateSOAPErrMessage(message, "no header block for next action");
				}
				
				Node macNode = (Node) it.next();
				String macValue = (macNode == null) ? null : macNode.getValue();
				
				if (macValue == null) {
					generateSOAPErrMessage(message, "no mac address in header block!");
				}
				
				// if mac address isn't matched, throw exception
				if (!macValue.equals("D4-3D-7E-EA-4C-87")) {
					generateSOAPErrMessage(message, "Invalid mac address, access is denied.");
				}
				
				// tracking
				message.writeTo(System.out);
				
			} catch (SOAPException | IOException e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		
		System.out.println("[MacAddressValidatorHandler] handleFault() ..... " );
		
		return true;
	}

	@Override
	public void close(MessageContext context) {
		System.out.println("[MacAddressValidatorHandler] close() ..... " );
	}

	@Override
	public Set<QName> getHeaders() {
		
		System.out.println("[MacAddressValidatorHandler] getHeaders() ..... " );
		
		return null;
	}

	private void generateSOAPErrMessage(SOAPMessage msg, String reason) {
		try {
			SOAPBody soapBody = msg.getSOAPPart().getEnvelope().getBody();
			SOAPFault soapFault = soapBody.addFault();
			soapFault.setFaultString(reason);
			throw new SOAPFaultException(soapFault);
		} catch (SOAPException e) {
			
		}
	}
}
