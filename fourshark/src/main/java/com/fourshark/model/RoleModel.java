package com.fourshark.model;

public class RoleModel  extends AbstractModel<RoleModel>{
	private String code;
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	} 
}
