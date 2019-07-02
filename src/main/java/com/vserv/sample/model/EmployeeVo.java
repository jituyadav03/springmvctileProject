package com.vserv.sample.model;

import java.io.Serializable;

public class EmployeeVo implements Serializable {

	
	/* @EmpIdCheck */
	String id;
	String name;
	
	public EmployeeVo(String id , String name) {
		this.id =id;
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
