package com.fourshark.sort;

public class Sorter {
	private String sortName;
	private String sortBy;
	private String sortCreatedDate;
	private String sortUsername;
	
	public Sorter(String sortName, String sortBy) {
		this.sortName = sortName;
		this.sortBy = sortBy;
	}
	
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

	public String getSortCreatedDate() {
		return sortCreatedDate;
	}

	public void setSortCreatedDate(String sortCreatedDate) {
		this.sortCreatedDate = sortCreatedDate;
	}

	public String getSortUsername() {
		return sortUsername;
	}

	public void setSortUsername(String sortUsername) {
		this.sortUsername = sortUsername;
	}

	
}
