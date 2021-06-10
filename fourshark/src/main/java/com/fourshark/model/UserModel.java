package com.fourshark.model;

public class UserModel extends AbstractModel<UserModel>{
	private String password;
	private String email;
	private String phoneNumber;
	private String fullName;
	private String gender;
	private long[] ids;
	private String sortName;
	private String sortBy;
	private RoleModel role;;
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getphoneNumber() {
		return phoneNumber;
	}
	public void setphoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getfullName() {
		return fullName;
	}
	public void setfullName(String fullName) {
		this.fullName = fullName;
	}


	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public RoleModel getRole() {
		return role;
	}
	public void setRole(RoleModel role) {
		this.role = role;
	}
	public long[] getIds() {
		return ids;
	}
	public void setIds(long[] ids) {
		this.ids = ids;
	}
}
