package com.Testing.pdf;


import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="testng-results")
public class Result {
	
	private int total;
	private int passed;
	private int failed;
	private List<Suite> suite;
	
	public Result()
	{
		
	}

	public Result(int total,int passed, int failed,List<Suite> suite) {
		this.total=total;
		this.passed=passed;
		this.failed=failed;
		this.suite = suite;
		
	}
	
	
	public int getTotal() {
		return total;
	}
	@XmlAttribute
	public void setTotal(int total) {
		this.total = total;
	}

	public int getPassed() {
		return passed;
	}
	 @XmlAttribute
	public void setPassed(int passed) {
		this.passed = passed;
	}

	public int getFailed() {
		return failed;
	}
	 @XmlAttribute
	public void setFailed(int failed) {
		this.failed = failed;
	}

	
	public List<Suite> getSuite() {
		return suite;
	}
    @XmlElement
	public void setSuite(List<Suite> suite) {
		this.suite = suite;
	}
	
	
	@Override
	public String toString() {
		return "Result [total="+total+", passed="+passed+",failed="+failed+" ,\n"
				+ " suite="+suite+"]";
	}

}
