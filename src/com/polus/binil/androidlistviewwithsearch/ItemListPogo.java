package com.polus.binil.androidlistviewwithsearch;

public class ItemListPogo {
	private String itemId;
	private String companyName;
	private String itemName;
	private String itemImageUrl;
	private String profileImageUrl;

	public ItemListPogo(String products, String name) {
		this.companyName = products;
		this.itemName = name;
	}


	public String getProductName() {
		return this.companyName;
	}

	public String getItemName() {
		return this.itemName;
	}

}
