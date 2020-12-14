package com.picocontainer;

public class Item {

	private String itemType;
	private int price;
	
	public Item(String itemType, int price) {
		this.itemType = itemType;
		this.price = price;
	}
	
	public Item(String itemType) {
		this.itemType = itemType;
		this.price = 100;
	}

	public int getPrice() {
		return this.price;
	}
	
	public String getItemType() {
		return itemType;
	}
}
