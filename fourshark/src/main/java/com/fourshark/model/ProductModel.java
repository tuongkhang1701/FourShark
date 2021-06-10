package com.fourshark.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ProductModel extends AbstractModel<ProductModel> implements Comparable<ProductModel>{
	private long categoryId;
	private String categoryCode;
	private String name;
	private String content;
	private String image;
	private int quantity;
	private BigDecimal price;
	private ArrayList<ProductModel> list;
	
	private int[] quantities;
	private long[] ids;
	private String sortName;
	private String sortBy;
	public ProductModel() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductModel(Long id, String name, BigDecimal Price, String Image) {
		this.setId(id);
		this.name = name;
		this.setPrice(Price);
		this.image = Image;
	}
	
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
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

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long[] getIds() {
		return ids;
	}
	public void setIds(long[] ids) {
		this.ids = ids;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public int compareTo(ProductModel pr) {
		
		return (int)(this.getId() - pr.getId());
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ArrayList<ProductModel> getList() {
		return list;
	}

	public void setList(ArrayList<ProductModel> list) {
		this.list = list;
	}

	public int[] getQuantities() {
		return quantities;
	}

	public void setQuantities(int[] quantities) {
		this.quantities = quantities;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	
}
