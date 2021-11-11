package com.Testing.pdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType (XmlAccessType.FIELD)
public class ExceptionClass {
	
	public String message;
	public String fullstacktrace;
	
	public ExceptionClass()
	{
		
	}
	

	public ExceptionClass(String message, String fullstacktrace) {
		super();
		this.message = message;
		this.fullstacktrace = fullstacktrace;
	}

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	//@XmlElement(name="full-stacktrace")
	public String getFullstacktrace() {
		return fullstacktrace;
	}


	public void setFullstacktrace(String fullstacktrace) {
		this.fullstacktrace = fullstacktrace;
	}


	@Override
	public String toString() {
		return "ExceptionClass [message=" + message + " , fullstacktrace="+fullstacktrace+" \n ]";
	}
	
	
}
