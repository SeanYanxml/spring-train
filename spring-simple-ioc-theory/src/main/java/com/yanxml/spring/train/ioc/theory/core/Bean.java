package com.yanxml.spring.train.ioc.theory.core;

import java.util.List;


public class Bean {
	private String id;
	private String className;
	private List<Property> propertyList;
	
	public Bean(String id,String className,List<Property> propertyList){
		super();
		this.id=id;
		this.className=className;
		this.propertyList=propertyList;
	}

	//Getter and Setter
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<Property> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List<Property> propertyList) {
		this.propertyList = propertyList;
	}
	

}
