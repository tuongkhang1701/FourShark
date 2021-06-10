package com.fourshark.paging;

import com.fourshark.sort.Sorter;

public interface Pageble {
	Integer getPage();
	
	Integer getOffset();
	
	Integer getLimit();
	
	Sorter getSorter();
}
