package com.Testing.pdf;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Params {

	private List<Param> param;
	
	public Params()
	{
		
	}
	
	
	public Params(List<Param> param) {
		super();
		this.param = param;
	}

	public List<Param> getParam() {
		return param;
	}

    @XmlElement(name = "param")
	public void setParam(List<Param> param) {
		this.param = param;
	}


	@Override
	public String toString() {
		return "Params [param=" + param + "\n]";
	}
    
    

}
