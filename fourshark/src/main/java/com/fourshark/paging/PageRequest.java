package com.fourshark.paging;

import com.fourshark.sort.Sorter;

public class PageRequest implements Pageble{

	private Integer page;
	private Integer maxPageItem;
	private Sorter sorter;
	 
	public PageRequest(Integer page, Integer maxPageItem, Sorter sorter) {
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.setSorter(sorter);
	}

	@Override
	public Integer getPage() {
		return this.page;
	}

	@Override
	public Integer getOffset() {
		if (this.page != null && this.maxPageItem != null) {			
			return ((this.page - 1) * this.maxPageItem);
		}
		return null;
	}

	@Override
	public Integer getLimit() {
		return this.maxPageItem;
	}
	
	public Integer getMaxPageItem() {
		return this.maxPageItem;
	}



	public void setMaxPageItem(Integer maxPageItem) {
		this.maxPageItem = maxPageItem;
	}



	public void setPage(Integer page) {
		this.page = page;
	}

	public Sorter getSorter() {
		if (this.sorter != null) {			
			return sorter;
		}
		return null;
	}

	public void setSorter(Sorter sorter) {
		this.sorter = sorter;
	}

}
