package com.Testing.pdf;


import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Class {

	private String name;
	private List<TestMethod> testmethod;
	
	
	public Class()
	{
		
	}
	

	public Class(String name,List<TestMethod> testmethod) {
		super();
		this.name = name;
		this.testmethod=testmethod;
	}


	@XmlAttribute
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	@XmlElement(name="test-method")
	public List<TestMethod> getTestmethod() {
		return testmethod;
	}


	public void setTestmethod(List<TestMethod> testmethod) {
		this.testmethod = testmethod;
	}


	@Override
	public String toString() {
		return "Class [name=" + name + ", test-method="+testmethod+"\n]";
	}
	
	
}
