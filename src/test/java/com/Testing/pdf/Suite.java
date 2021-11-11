package com.Testing.pdf;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Suite {

	private String name;
	private long suite_duration;
	private List<Test> test;
	
	public Suite()
	{
		
	}
	

	public Suite(String name,long suite_duration,List<Test> test) {
		super();
		this.name = name;
		this.suite_duration = suite_duration;
		this.test = test;
	}

	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	@XmlAttribute(name="duration-ms")
	public long getSuite_duration() {
		return suite_duration;
	}


	public void setSuite_duration(long suite_duration) {
		this.suite_duration = suite_duration;
	}


	public List<Test> getTest() {
		return test;
	}
	
    @XmlElement
	public void setTest(List<Test> test) {
		this.test = test;
	}

	

	@Override
	public String toString() {
		return "Suite [name=" + name + ", duration="+suite_duration+" Test ="+test+"]\n";
	}
	
	
}
