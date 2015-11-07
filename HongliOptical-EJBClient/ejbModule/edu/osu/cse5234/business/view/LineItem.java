package edu.osu.cse5234.business.view;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_ORDER_LINE_ITEM")
public class LineItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6032667610110738302L;
	
	private int id;
	private int itemId;
	private String itemName;
	private int quantity;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="ITEM_ID")
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	@Column(name="ITEM_NAME")
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	@Column(name="QUANTITY")
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
