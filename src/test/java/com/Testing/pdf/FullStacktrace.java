package com.Testing.pdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name="full-stacktrace")
@XmlAccessorType (XmlAccessType.FIELD)
public class FullStacktrace {
	
	private String fullstack;
	
	public FullStacktrace()
	{
		
	}

	public FullStacktrace(String fullstack) {
		super();
		this.fullstack = fullstack;
	}



	public String getFullstack() {
		return fullstack;
	}



	public void setFullstack(String fullstack) {
		this.fullstack = fullstack;
	}



	@Override
	public String toString() {
		return "FullStacktrace [fullstack=" + fullstack + "]";
	}
	
	
	
}
