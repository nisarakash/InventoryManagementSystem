package com.spring.model;

import java.util.Date;

public class Item {
	private Long id;
	private String name;
	private Double unitPrice;
	private Date manufactureDate;

	public Item(long itemId, String itemName, Double unitPrice) {
		super();
		this.id = itemId;
		this.name = itemName;
		this.unitPrice = unitPrice;
		this.manufactureDate = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

}
