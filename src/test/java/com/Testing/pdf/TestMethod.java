package com.Testing.pdf;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class TestMethod {

	private String name;
	private long durationms;
	private String test_status;
	private List<ExceptionClass> exception;
	private List<Params> params;
	
	
	public TestMethod()
	{
		
	}
	

	public TestMethod(String name,long durationms,String test_status,List<ExceptionClass> exception,List<Params> params) {
		super();
		this.durationms = durationms;
		this.name = name;
		this.test_status = test_status;
		this.exception=exception;
		this.params=params;
	}

	
	@XmlAttribute(name = "duration-ms")
	public long getDurationms() {
		return durationms;
	}


	public void setDurationms(long durationms) {
		this.durationms = durationms;
	}


	@XmlAttribute
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	@XmlAttribute(name="status")
	public String getTest_status() {
		return test_status;
	}


	public void setTest_status(String test_status) {
		this.test_status = test_status;
	}


	@XmlElement(name="exception")
	public List<ExceptionClass> getException() {
		return exception;
	}


	public void setException(List<ExceptionClass> exception) {
		this.exception = exception;
	}

	
	@XmlElement(name="params")
	public List<Params> getParams() {
		return params;
	}


	public void setParams(List<Params> params) {
		this.params = params;
	}


	@Override
	public String toString() {
		return "TestMethod [name=" + name + ", duration ="+durationms+" , test status="+test_status+" , Exception="+exception+" , params="+params+" ]";
	}
	
}
