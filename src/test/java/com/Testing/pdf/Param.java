package com.Testing.pdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "param")
@XmlAccessorType (XmlAccessType.FIELD)
public class Param {

	public String value;
	
	public Param()
	{
		
	}
	
	public Param(String value) {
		super();
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Param [value=" + value + "\n]";
	}
	
}
