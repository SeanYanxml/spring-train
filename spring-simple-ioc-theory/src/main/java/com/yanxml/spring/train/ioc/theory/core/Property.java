package com.yanxml.spring.train.ioc.theory.core;

public class Property {
	private String name;
	private String ref;
	
	public Property(String name,String ref){
		super();
		this.name=name;
		this.ref=ref;
	}

	//Getter and Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

}
