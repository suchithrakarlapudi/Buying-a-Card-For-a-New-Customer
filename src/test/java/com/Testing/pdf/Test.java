package com.Testing.pdf;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Test {

	private String name;
	private long test_duration;
	
	private List<Class> classmethod;
	
	public Test()
	{
		
	}
	

	public Test(String name,long test_duration,List<Class> classmethod) {
		super();
		this.name = name;
		this.test_duration = test_duration;
		this.classmethod=classmethod;
	}

	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@XmlAttribute(name="duration-ms")
	 public long getTest_duration() {
		return test_duration;
	}


	public void setTest_duration(long test_duration) {
		this.test_duration = test_duration;
	}


	@XmlElement(name="class")
	public List<Class> getClassmethod() {
		return classmethod;
	}


	public void setClassmethod(List<Class> classmethod) {
		this.classmethod = classmethod;
	}


	@Override
	public String toString() {
		return "Test [name ="+name+" , test duration="+test_duration+"  , class="+classmethod+"]\n";
	}
	

}
