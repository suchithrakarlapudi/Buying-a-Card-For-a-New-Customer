package com.Testing.pdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType (XmlAccessType.FIELD)
public class Message {
	
	private String message;

	@Override
	public String toString() {
		return "Message [message=" + message + "]";
	}

}
