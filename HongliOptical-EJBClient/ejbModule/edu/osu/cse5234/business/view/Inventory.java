package edu.osu.cse5234.business.view;

import java.io.Serializable;
import java.util.List;

public class Inventory implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3139720708891326403L;
	private List<Item> itemList;
	
	public Inventory() {
		
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	

}
